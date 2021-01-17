package com.example.notebook3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MemoDetailActivity extends AppCompatActivity {

    private EditText detailTitle;
    private EditText detailContent;
    private MemoDatabase db;

    private int id;
    private String title;
    private String content;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_detail);

        detailTitle = findViewById(R.id.titleDetail);
        detailContent = findViewById(R.id.contentDetail);
        db = MemoDatabase.getInstance(this);

        init();


        // 수정
        ImageButton writeDetail = (ImageButton) findViewById(R.id.writeDetail);
        writeDetail.setOnClickListener(v -> {
            title = detailTitle.getText().toString();
            content = detailContent.getText().toString();
            db.memoDao().update(title, content, id);
            finish();
        });

        ImageButton cancelDetail = (ImageButton) findViewById(R.id.cancelDetail);
        cancelDetail.setOnClickListener(v -> {
            finish();
        });
    }

    private void init() {
        Memo detail = getIntent().getParcelableExtra("data");

        id = detail.getId();
        title = detail.getTitle();
        content = detail.getContent();

        detailTitle.setText(title);
        detailContent.setText(content);
    }
}
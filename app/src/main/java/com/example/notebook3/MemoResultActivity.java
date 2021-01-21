package com.example.notebook3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MemoResultActivity extends AppCompatActivity {

    private TextView titleResult;
    private TextView contextResult;
    private String title;
    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_result);

        titleResult = (TextView) findViewById(R.id.titleResult);
        contextResult = (TextView) findViewById(R.id.contentResult);

        Memo result = getIntent().getParcelableExtra("data");


        title = result.getTitle();
        content = result.getContent();

        titleResult.setText(title);
        contextResult.setText(content);

        ImageButton backButton = (ImageButton) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
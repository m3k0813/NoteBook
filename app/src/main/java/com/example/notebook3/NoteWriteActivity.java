package com.example.notebook3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.notebook3.R;

import java.util.Dictionary;

public class NoteWriteActivity extends AppCompatActivity {

    EditText titleInput;
    EditText contentInput;
    MemoDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_write);

        titleInput = (EditText) findViewById(R.id.titleInput);
        contentInput = (EditText) findViewById(R.id.contentInput);

        db = MemoDatabase.getInstance(this);

        ImageButton writeButton = (ImageButton) findViewById(R.id.writeButton);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    writeMemo();
            }
        });

        ImageButton cancelButton = (ImageButton) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void writeMemo() {      //메인으로
            String title = titleInput.getText().toString();
            String content = contentInput.getText().toString();

            //DB에 저장
            Memo memo = new Memo(title, contentInput.getText().toString());
            db.memoDao().insert(memo);
            Toast.makeText(getApplicationContext(),"저장되었습니다",Toast.LENGTH_SHORT).show();
            finish();
        }
    }


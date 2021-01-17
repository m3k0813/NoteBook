package com.example.notebook3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private List<Memo> memos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        //작성 버튼
        Button button = (Button) findViewById(R.id.WriteButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNoteWriteActivity();

            }
        });

    }

    //노트 작성 화면 띄우기
    public void showNoteWriteActivity() {
        Intent intent = new Intent(getApplicationContext(), com.example.notebook3.NoteWriteActivity.class);
        startActivityForResult(intent, 102);

    }


    //RecyclerView 사용
    private void init() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        memos = MemoDatabase.getInstance(this).memoDao().getAll();
        int size = memos.size();
        for (int i = 0; i < size; i++) {
            adapter.addItem(memos.get(i));

        }
    }


    //DB로부터 값 전달
    @Override
    public void onStart() {
        memos = MemoDatabase.getInstance(this).memoDao().getAll();
        adapter.addItems((ArrayList) memos);
        super.onStart();
    }

}









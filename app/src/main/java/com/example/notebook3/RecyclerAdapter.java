package com.example.notebook3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;

import com.google.android.material.tabs.TabItem;

import java.util.ArrayList;
import java.util.Dictionary;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    private ArrayList<Memo> listData = new ArrayList<>();
    private Context context;
    private MemoDatabase db;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        context = parent.getContext();     //context 생성
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        holder.onBind(listData.get(position), position);
    }

    @Override
    public int getItemCount() {

        return listData.size();
    }

    void addItem(Memo memo) {

        listData.add(memo);
        notifyDataSetChanged();
    }

    void addItems(ArrayList<Memo> memos) {
        listData = memos;
        notifyDataSetChanged();
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView textView1;
        private TextView textView2;

        ItemViewHolder(View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.titleText);
            textView2 = itemView.findViewById(R.id.contentText);
        }

        void onBind(Memo memo, int position) {
            textView1.setText(memo.getTitle());
            textView2.setText(memo.getContent());

            //클릭 시 메모 보기
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), MemoResultActivity.class);
                intent.putExtra("data", memo);
                itemView.getContext().startActivity(intent);
            });

            //길게 클릭 시 수정, 삭제 다이얼로그
            itemView.setOnLongClickListener(v -> {
            AlertDialog.Builder ab = new AlertDialog.Builder(context); //context 객체를 생성해야 함
                ab.setTitle("메모").setMessage("메모 선택");
                ab.setNeutralButton("수정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(itemView.getContext(), MemoDetailActivity.class);
                        intent.putExtra("data", memo);
                        itemView.getContext().startActivity(intent);
                    }
                });

                ab.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listData.remove(memo);
                        MemoDatabase.getInstance(itemView.getContext()).memoDao().delete(memo);

                        notifyDataSetChanged();
                    }
                });
                ab.show();
                return false;
            });

        }
    }
}


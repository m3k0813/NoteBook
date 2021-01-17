package com.example.notebook3;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;

import com.google.android.material.tabs.TabItem;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    private ArrayList<Memo> listData = new ArrayList<>();

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
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

            //길게 클릭 시 수정화면
            itemView.setOnLongClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), MemoDetailActivity.class);
                intent.putExtra("data", memo);
                itemView.getContext().startActivity(intent);
                return false;
            });

        }
    }

}

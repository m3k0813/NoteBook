package com.example.notebook3;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Memo.class}, version = 2, exportSchema = false)
public abstract class MemoDatabase extends RoomDatabase {

    public abstract MemoDao memoDao();
    private static MemoDatabase instance = null;


    public static synchronized MemoDatabase getInstance(Context context){
        if(instance == null){
            instance =  Room.databaseBuilder(context.getApplicationContext(),
                    MemoDatabase.class, "memo_Database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}

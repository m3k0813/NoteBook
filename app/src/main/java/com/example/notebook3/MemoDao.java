package com.example.notebook3;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MemoDao {

    @Query("SELECT * FROM memoTable")
    List<Memo> getAll();

    @Query("DELETE FROM memoTable")
    void deleteAll();

    @Query("UPDATE memoTable SET memo_title = :t, memo_content = :d WHERE memo_id =:id")
    void update(String t, String d, int id);

    @Insert
    void insert(Memo memo);

    @Update
    void update(Memo memo);

    @Delete
    void delete(Memo memo);
}

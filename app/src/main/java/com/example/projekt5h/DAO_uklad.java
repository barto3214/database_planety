package com.example.projekt5h;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

@Dao
public interface DAO_uklad {
    @Insert
    long insertUser(Planeta planeta);

    @Insert
    void insertNote(Gwiazda gwiazda);

    @Transaction
    @Query("SELECT * FROM planety WHERE id = :userId")
    Uklad getUserWithNotes(int userId);
}

package com.example.projekt5h;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Planeta.class, Gwiazda.class}, version = 1)
public abstract class Database_uklady extends RoomDatabase {
    public abstract DAO_uklad ukladDao();


}

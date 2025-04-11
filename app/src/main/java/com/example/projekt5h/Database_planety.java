package com.example.projekt5h;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Planeta.class}, version = 5,exportSchema = false)
public abstract class Database_planety extends RoomDatabase {
    public abstract dao_planeta zwroc_dao_planeta();
}

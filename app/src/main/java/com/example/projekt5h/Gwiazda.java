package com.example.projekt5h;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(
        entity = Planeta.class,
        parentColumns = "id",
        childColumns = "gwiazdaId",
        onDelete = ForeignKey.CASCADE
))
public class Gwiazda {

        @PrimaryKey(autoGenerate = true)
        public long Id;

        public String uklad;

        @ColumnInfo(index = true)
        public int gwiazdaId;


}

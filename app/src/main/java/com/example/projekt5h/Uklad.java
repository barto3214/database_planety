package com.example.projekt5h;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class Uklad {
    @Embedded
    public Planeta planeta;

    @Relation(
            parentColumn = "id",
            entityColumn = "gwiazdaId"
    )
    public List<Gwiazda> gwiazdy;
}

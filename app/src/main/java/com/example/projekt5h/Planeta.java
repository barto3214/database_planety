package com.example.projekt5h;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "planety")
public class Planeta {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private int id;
    private String nazwa;
    private int rok_odkrycia;

    @ColumnInfo(name ="czas_w_dniach")
    private int czasDni;
    private int miejsce_od_gwiazdy;

    @Ignore
    public Planeta() {
    }

    public Planeta(String nazwa, int rok_odkrycia, int czasDni, int miejsce_od_gwiazdy) {
        id = 0;
        this.nazwa = nazwa;
        this.rok_odkrycia = rok_odkrycia;
        this.czasDni = czasDni;
        this.miejsce_od_gwiazdy = miejsce_od_gwiazdy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getRok_odkrycia() {
        return rok_odkrycia;
    }

    public void setRok_odkrycia(int rok_odkrycia) {
        this.rok_odkrycia = rok_odkrycia;
    }

    public int getCzasDni() {
        return czasDni;
    }

    public void setCzasDni(int czasDni) {
        this.czasDni = czasDni;
    }

    public int getMiejsce_od_gwiazdy() {
        return miejsce_od_gwiazdy;
    }

    public void setMiejsce_od_gwiazdy(int miejsce_od_gwiazdy) {
        this.miejsce_od_gwiazdy = miejsce_od_gwiazdy;
    }
}

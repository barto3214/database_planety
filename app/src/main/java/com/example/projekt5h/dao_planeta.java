package com.example.projekt5h;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface dao_planeta {
    @Insert
    public void wstaw_planete(Planeta planeta);

    @Delete
    public void usun_planete(Planeta planeta);

    @Update
    public void zaktualizuj_planete(Planeta planeta);

    @Query("SELECT * FROM planety")
    public List<Planeta> zwroc_planety();

    @Query("SELECT * FROM planety WHERE rok_odkrycia = :rok_teraz")
    public List<Planeta> zwroc_planety_rok(int rok_teraz);
}

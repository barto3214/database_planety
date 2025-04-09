package com.example.projekt5h;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.projekt5h.databinding.ActivityMainBinding;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private ArrayAdapter<Planeta> array_adapter;
    private List<Planeta> gryplanety;
    Database_planety database_planety;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        RoomDatabase.Callback callback =new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }

            @Override
            public void onDestructiveMigration(@NonNull SupportSQLiteDatabase db) {
                super.onDestructiveMigration(db);
            }
        };

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nazwa = binding.nazwa.getText().toString();
                int rok = Integer.valueOf(binding.spinnerRok.getSelectedItem().toString());
                int czasdni = Integer.parseInt(binding.spinnerCzasDni.getSelectedItem().toString());
                int miejsce = Integer.parseInt(binding.spinnerMiejsce.getSelectedItem().toString());
                Planeta planeta = new Planeta(nazwa,rok,czasdni,miejsce);
                dodajplanetedobazy(planeta);
            }
        });
        database_planety = Room.databaseBuilder(
                MainActivity.this,
                Database_planety.class,
                "Planety_DB").addCallback(callback).allowMainThreadQueries().build();
        wypiszplanety();

    }
    private void dodajplanetedobazy(Planeta boardgame){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                database_planety.zwroc_dao_planeta().wstaw_planete(new Planeta("Jupiter",2005,370,16));
                database_planety.zwroc_dao_planeta().wstaw_planete(boardgame);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Dodano do bazy", Toast.LENGTH_SHORT);
                    }
                });
            }
        });
    }
private void wypiszplanety(){
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Handler handler = new Handler(Looper.getMainLooper());
    executorService.execute(new Runnable() {
        @Override
        public void run() {
            gryplanety = database_planety.zwroc_dao_planeta().zwroc_planety();

            handler.post(new Runnable() {
                @Override
                public void run() {
                    array_adapter = new ArrayAdapter<>(
                            MainActivity.this,
                            android.R.layout.simple_list_item_1,
                            gryplanety
                    );
                    binding.listveiw.setAdapter(array_adapter);
                }


                }
            );
        }
    });
}
}

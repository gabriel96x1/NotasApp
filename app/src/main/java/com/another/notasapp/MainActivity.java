package com.another.notasapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.another.notasapp.adapters.FolderNotesAdapter;
import com.another.notasapp.models.entity.FolderNotes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AppDatabase db;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").fallbackToDestructiveMigration().build();

        Button nextActivity = findViewById(R.id.nextActivity);
        // Se crea una lista de objetos dummy para hacer pruebas
        List<FolderNotes> dummyData = null;
        try {
            dummyData = getFolders();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Se configura el recycler view
        RecyclerView.Adapter adapterFolderNotes = new FolderNotesAdapter(dummyData);
        recyclerView = findViewById(R.id.foldersRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapterFolderNotes);

        // Se notifica el cambio en el adapter
        adapterFolderNotes.notifyDataSetChanged();

        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextAct = new Intent(MainActivity.this, NotesActivity.class);
                startActivity(nextAct);

            }
        });
    }


    public List<FolderNotes> getFolders() throws ExecutionException, InterruptedException {

        Callable< List<FolderNotes>> callable = new Callable<List<FolderNotes>>() {
            @Override
            public  List<FolderNotes> call() throws Exception {
                return db.folderDao().getAllFolders();
            }
        };
        Future<List<FolderNotes>> future = Executors.newSingleThreadExecutor().submit(callable);

        return future.get();
    }



}
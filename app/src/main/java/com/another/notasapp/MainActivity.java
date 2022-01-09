package com.another.notasapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.another.notasapp.adapters.FolderNotesAdapter;
import com.another.notasapp.models.entity.FolderNotes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Se crea una lista de objetos dummy para hacer pruebas
        List<FolderNotes> dummyData = new ArrayList<>();
        FolderNotes folderNotes = new FolderNotes();
        FolderNotes folderNotes2 = new FolderNotes();
        folderNotes.setName("Nuevo nombre");
        folderNotes2.setName("Otro nombre");
        dummyData.add(folderNotes);
        dummyData.add(folderNotes2);

        // Se configura el recycler view
        RecyclerView.Adapter adapterFolderNotes = new FolderNotesAdapter(dummyData);
        recyclerView = findViewById(R.id.foldersRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapterFolderNotes);

        // Se notifica el cambio en el adapter
        adapterFolderNotes.notifyDataSetChanged();
    }
}
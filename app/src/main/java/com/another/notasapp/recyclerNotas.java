package com.another.notasapp;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.security.AccessController;

public class recyclerNotas extends AppCompatActivity {
    private RecyclerView rView;
    private NotesAdapter rAdapter;
    private static final String[] myDataSet = {
            "PHP",
            "Javascript",
            "Go",
            "Python"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_notas2);

        rView = findViewById(R.id.recyclerViewNotas);

        // Esta línea mejora el rendimiento, si sabemos que el contenido
        // no va a afectar al tamaño del RecyclerView
        rView.setHasFixedSize(true);

        // Nuestro RecyclerView usará un linear layout manager
        GridLayoutManager layoutManager = new GridLayoutManager();
        rView.setLayoutManager(layoutManager);

        // Asociamos un adapter (ver más adelante cómo definirlo)
        rAdapter = new MyAdapter(myDataSet);
        rView.setAdapter(rAdapter);




    }
}
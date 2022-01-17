package com.another.notasapp.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.room.Room;

import com.another.notasapp.AppDatabase;
import com.another.notasapp.models.entity.FolderNotes;

import java.util.concurrent.ExecutionException;

public class AddFolderDialog extends DialogFragment {
    private AppDatabase db;
    OnSaveNewFolder callback;

    public void setOnSaveNewFolder(OnSaveNewFolder onSaveNewFolder){
        this.callback = onSaveNewFolder;
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        builder.setMessage("Agrega un deck")
                .setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getContext(), "Se ha guardado lo que escribiste", Toast.LENGTH_LONG ).show();
                        FolderNotes folderNotes = new FolderNotes();
                        folderNotes.setName("name");

                        try {
                            callback.onFolderSaved(folderNotes);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        return builder.create();
    }

    public interface OnSaveNewFolder {
        public void onFolderSaved(FolderNotes folderNotes) throws ExecutionException, InterruptedException;
    }
}

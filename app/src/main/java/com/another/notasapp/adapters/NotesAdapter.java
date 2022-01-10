package com.another.notasapp.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.another.notasapp.R;
import com.another.notasapp.models.entity.FolderNotes;
import com.another.notasapp.models.entity.Notes;

import java.util.List;


public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder>{

    private List<Notes> NotesData;
    public NotesAdapter(List<Notes> dataSet) {
        this.NotesData = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notes_item_list, parent, false);

        return new NotesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.i("BindViewHolder", "Se enlaza la vista de " + this.NotesData.get(position).getName());
        holder.getTextView().setText(this.NotesData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return this.NotesData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.item_list);
        }
        public TextView getTextView() {
            return textView;
        }
    }



}

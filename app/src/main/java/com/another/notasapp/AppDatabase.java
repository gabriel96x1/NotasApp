package com.another.notasapp;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.another.notasapp.dao.FolderDao;
import com.another.notasapp.models.entity.FolderNotes;
import com.another.notasapp.models.entity.Notes;

@Database(entities = {FolderNotes.class, Notes.class}, version = 2)
public abstract class AppDatabase extends    RoomDatabase {
    public abstract FolderDao folderDao();
}

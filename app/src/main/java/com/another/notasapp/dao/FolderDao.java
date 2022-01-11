package com.another.notasapp.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.another.notasapp.models.entity.FolderNotes;

import java.util.List;

@Dao
public interface FolderDao {
    @Query("SELECT * FROM FolderNotes")
    public List<FolderNotes> getAllFolders();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDeck(FolderNotes folderNote);


}

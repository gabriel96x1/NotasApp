package com.another.notasapp.models.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Notes {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo
    public String title;

    public String text;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) { this.uid = uid; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

}

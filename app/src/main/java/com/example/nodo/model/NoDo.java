package com.example.nodo.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "nodo_table")
public class NoDo {


    @PrimaryKey(autoGenerate = true)
    private  int id;

    @NonNull
    @ColumnInfo(name = "nodo_col")
    private final String noDo;

    public NoDo(@NonNull String noDo) {
        this.noDo = noDo;
    }

    @NonNull
    public String getNoDo() {
        return noDo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

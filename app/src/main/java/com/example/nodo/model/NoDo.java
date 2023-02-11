package com.example.nodo.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "noDo")
public class NoDo {


    @PrimaryKey(autoGenerate = true)
    private  int id;
    private final String noDo;

    public NoDo(String noDo) {
        this.noDo = noDo;
    }

    public String getNoDo() {
        return noDo;
    }
}

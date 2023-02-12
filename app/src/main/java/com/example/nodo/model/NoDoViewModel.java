package com.example.nodo.model;

import android.app.Application;
import android.content.Context;
import android.hardware.lights.LightState;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.nodo.utils.NoDoRepository;

import java.util.List;

public class NoDoViewModel extends AndroidViewModel {

    private NoDoRepository noDoRepository;
    private LiveData<List<NoDo>> allNoDoes;

    public NoDoViewModel(@NonNull Application application) {
        super(application);

        noDoRepository = new NoDoRepository(application);
        allNoDoes = noDoRepository.getAllNoDos();

    }

    public LiveData<List<NoDo>> getAllNoDoes(){

        return allNoDoes;
    }

    public void insert(NoDo noDo){

        noDoRepository.insert(noDo);
    }

}

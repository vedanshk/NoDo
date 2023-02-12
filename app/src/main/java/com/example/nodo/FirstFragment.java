package com.example.nodo;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nodo.databinding.FragmentFirstBinding;
import com.example.nodo.model.NoDo;
import com.example.nodo.model.NoDoViewModel;
import com.example.nodo.ui.NoDoListAdapter;

import java.util.List;
import java.util.Objects;

public class FirstFragment extends Fragment {

    RecyclerView recyclerView;
    NoDoListAdapter noDoListAdapter;

    NoDoViewModel noDoViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_first , container  , false);



        noDoViewModel = new ViewModelProvider(this).get(NoDoViewModel.class);


        recyclerView = view.findViewById(R.id.recyclerView);

        noDoListAdapter = new NoDoListAdapter(getContext());

        recyclerView.setAdapter(noDoListAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        noDoViewModel.getAllNoDoes().observe(getViewLifecycleOwner(), noDos -> noDoListAdapter.setNodo(noDos));

        return view;
    }





}
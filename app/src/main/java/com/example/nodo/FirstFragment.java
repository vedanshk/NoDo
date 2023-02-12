package com.example.nodo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nodo.databinding.FragmentFirstBinding;
import com.example.nodo.ui.NoDoListAdapter;

public class FirstFragment extends Fragment {

    RecyclerView recyclerView;
    NoDoListAdapter noDoListAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_first , container  , false);

        recyclerView = view.findViewById(R.id.recyclerView);

        noDoListAdapter = new NoDoListAdapter(getContext());

        recyclerView.setAdapter(noDoListAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));




        return view;
    }



}
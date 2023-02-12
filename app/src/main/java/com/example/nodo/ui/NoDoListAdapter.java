package com.example.nodo.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nodo.R;
import com.example.nodo.model.NoDo;

import java.util.ArrayList;
import java.util.List;

public class NoDoListAdapter extends  RecyclerView.Adapter<NoDoListAdapter.ViewHolder>{

    Context context;

    private List<NoDo> nodo = new ArrayList<>();

    public NoDoListAdapter(Context context) {
        this.context = context;
    }

    public void setNodo(List<NoDo> nodo) {
        this.nodo = nodo;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.textView.setText(nodo.get(position).getNoDo());


    }

    @Override
    public int getItemCount() {
        return nodo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}

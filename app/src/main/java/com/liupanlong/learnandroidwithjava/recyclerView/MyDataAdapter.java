package com.liupanlong.learnandroidwithjava.recyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyDataAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<Data> data;
    private Context activityContext;

    public MyDataAdapter(Context activityContext, List<Data> data) {
        this.activityContext = activityContext;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MyViewHolder.newInstants(activityContext, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Data data = this.data.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

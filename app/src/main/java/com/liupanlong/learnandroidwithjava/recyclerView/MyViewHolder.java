package com.liupanlong.learnandroidwithjava.recyclerView;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.liupanlong.learnandroidwithjava.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private View itemView;
    private TextView numView;
    private TextView textView;
    private MyClickListener clickListener;

    private MyViewHolder(@NonNull View itemView, MyClickListener clickListener) {
        super(itemView);
        numView = itemView.findViewById(R.id.intShow);
        textView = itemView.findViewById(R.id.textShow);
        this.itemView = itemView;
        this.clickListener = clickListener;
    }
    public void bind(Data item) {
        numView.setText(String.valueOf(item.getId()));
        textView.setText(item.getText());
        // 设置item的监听函数，可以实现点击不同跳转
        itemView.setOnClickListener(view -> {
            clickListener.onClick(item.getToActivityId());
            // Toast.makeText(itemView.getContext(), item.getText(), Toast.LENGTH_SHORT).show();
        });
    }

    public static MyViewHolder newInstants(Context activityContext, ViewGroup parent){
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        View root = from.inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(root, (toActivity -> {
            Intent intent = new Intent(activityContext, toActivity);
            startActivity(intent);
        }));
    }
}

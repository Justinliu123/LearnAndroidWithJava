package com.liupanlong.learnandroidwithjava.recyclerView;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.liupanlong.learnandroidwithjava.R;
import com.liupanlong.learnandroidwithjava.ViewPager2.ViewPagerMainActivity;
import com.liupanlong.learnandroidwithjava.activity.LifecyclePart;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mycycler;
    List<Data> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mycycler = findViewById(R.id.recyclerView1);
        mycycler.setLayoutManager(new LinearLayoutManager(this));
        MyDataAdapter myDataAdapter = new MyDataAdapter(this, createData());
        mycycler.setAdapter(myDataAdapter);
    }

    private List<Data> createData(){
        list = new ArrayList<>();
        list.add(new Data(1,"这是1", com.liupanlong.learnandroidwithjava.dataBinding.DataBindingActivity.class));
        list.add(new Data(2,"这是2", ViewPagerMainActivity.class));
        list.add(new Data(3,"这是3", LifecyclePart.class));
        list.add(new Data(3,"这是3", LifecyclePart.class));
        list.add(new Data(3,"这是3", LifecyclePart.class));
        list.add(new Data(3,"这是3", LifecyclePart.class));
        list.add(new Data(3,"这是3", LifecyclePart.class));
        list.add(new Data(3,"这是3", LifecyclePart.class));
        list.add(new Data(3,"这是3", LifecyclePart.class));
        list.add(new Data(3,"这是3", LifecyclePart.class));
        list.add(new Data(3,"这是3", LifecyclePart.class));
        list.add(new Data(3,"这是3", LifecyclePart.class));
        list.add(new Data(3,"这是3", LifecyclePart.class));
        list.add(new Data(3,"这是3", LifecyclePart.class));
        list.add(new Data(3,"这是3", LifecyclePart.class));
        return list;
    }

}
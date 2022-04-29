package com.liupanlong.learnandroidwithjava.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.liupanlong.learnandroidwithjava.R;
import com.liupanlong.learnandroidwithjava.behavior.LiveDataTest;
import com.liupanlong.learnandroidwithjava.behavior.MyLifecycleObserver;
import com.liupanlong.learnandroidwithjava.behavior.MyViewModel;
import com.liupanlong.learnandroidwithjava.behavior.MyViewModelFactory;

public class LifecyclePart extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_part);

        // 携带参数的Viewmodel的创建方式，通过设置create的工厂方法实现
        // LiveDataTest viewModel = new ViewModelProvider(this, new MyViewModelFactory()).get(LiveDataTest.class);
        // 无参的ViewModel创建
        LiveDataTest viewModel1 = new ViewModelProvider(this).get(LiveDataTest.class);

        //添加生命周期监测器
        getLifecycle().addObserver(new MyLifecycleObserver(viewModel1));

        Button liveDataChange = findViewById(R.id.btnLiveDataChange);
        liveDataChange.setOnClickListener(view -> {
            viewModel1.getCounter().setValue(viewModel1.getCounter().getValue() - 1);
        });

        TextView showLiveData = findViewById(R.id.textViewShowLiveData);

        viewModel1.getMediatorLiveData().observe(this, value -> {
            showLiveData.setText(value);
        });

        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        TextView viewModelShow = findViewById(R.id.viewModelShow);
        viewModelShow.setText(myViewModel.modeData.getValue());

        findViewById(R.id.btnViewModelShow).setOnClickListener(view -> {
            myViewModel.showToast("点击Activity的按钮，viewModel做出响应");
        });

    }
}
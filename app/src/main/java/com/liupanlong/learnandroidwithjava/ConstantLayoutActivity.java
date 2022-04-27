package com.liupanlong.learnandroidwithjava;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.liupanlong.learnandroidwithjava.entity.User;

import cn.hutool.core.text.StrFormatter;

public class ConstantLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constant_layout);
        Intent intent = getIntent();
        User user1 = intent.getParcelableExtra("Object1");
        User user2 = intent.getParcelableExtra("Object2");
        TextView textView1 = findViewById(R.id.textView2);
        textView1.setText(StrFormatter.format("用户名：{} 性别：{}  年龄：{}", user1.getName(), user1.getSex(), user1.getAge()));
        TextView textView2 = findViewById(R.id.textView3);
        textView2.setText(StrFormatter.format("用户名：{} 性别：{}  年龄：{}", user2.getName(), user2.getSex(), user2.getAge()));
    }
}

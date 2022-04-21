package com.liupanlong.learnandroidwithjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        int x = 0;
        textView.setText("点击了" + x + "次");
        Button button = findViewById(R.id.button);
        button.setOnClickListener((view) -> {
            textView.setText("点击了" + x + "次");
        });
    }
}
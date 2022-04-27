package com.liupanlong.learnandroidwithjava;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CallbackActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.callback_activity);
        EditText editText = findViewById(R.id.callbackEditText);
        editText.setText(getIntent().getStringExtra("Str"));

        Button button = findViewById(R.id.callbackMainButton);
        button.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("resStr", editText.getText().toString());
            setResult(1, intent);
            finish();
        });
    }
}

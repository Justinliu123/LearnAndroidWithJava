package com.liupanlong.learnandroidwithjava;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.liupanlong.learnandroidwithjava.activity.ChooseImage;
import com.liupanlong.learnandroidwithjava.entity.User;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

import cn.hutool.core.text.StrFormatter;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    // 成员变量的值在应用回到桌面后，再次回来会被重新初始化
    private Integer counter = 0;
    // 静态变量的值不会重新初始化
    private static Integer staCounter = 0;

    // 调用activity的launcher
    private ActivityResultLauncher<Intent> launcher1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 注册launcher
        launcher1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), (result) -> {
            if(result == null) {
                textView.setText("launcher1 返回错误");
                return;
            }
            if(result.getResultCode() == 1) {
                textView.setText(result.getData().getStringExtra("resStr"));
            }
        });

        if(savedInstanceState != null){
            staCounter = savedInstanceState.getInt("counter");
        }
        textView = findViewById(R.id.textView);

        textView.setText(StrFormatter.format("点击了 {} 次", staCounter));
        Button button = findViewById(R.id.button);
        button.setOnClickListener((view) -> {
            textView.setText(StrFormatter.format("点击了 {} 次", ++staCounter));
            ((Button) view).setText(StrFormatter.format("button{}", staCounter));
        });
        Button toastButton = findViewById(R.id.toastButton);
        toastButton.setOnClickListener((view) -> {
            Toast.makeText(this, "I am clicked @ " + LocalTime.now(), Toast.LENGTH_SHORT).show();
        });
        Button alertDialog = findViewById(R.id.alertDialog);
        alertDialog.setOnClickListener((view) -> {
            new AlertDialog.Builder(this)
                    .setMessage("这是一个阻塞式的对话框")
                    .setPositiveButton("ok", (dialogInterface, which) -> {
                        textView.setText("Ok!");
                    })
                    .setNegativeButton("Cancel", (dialogInterface, which) -> {
                        textView.setText("Canceled!");
                    }).create().show();
        });

        // 向调用的Activity出入数据
        ImageView toConstantLayout = findViewById(R.id.toConstantLayout);
        toConstantLayout.setOnClickListener((view) -> {
            Intent intent = new Intent(this, ConstantLayoutActivity.class);
            // 向这另一个activity中传数据
            Bundle bundle = new Bundle();
            bundle.putParcelable("Object1",new User("张三", "男", 18));
            bundle.putSerializable("Object2",new User("李四", "女", 20));
            intent.putExtras(bundle);
            startActivity(intent);
        });

        // 多Activity双向数据传输
        ImageView tocallbackActivity = findViewById(R.id.tocallbackActivity);
        tocallbackActivity.setOnClickListener(view -> {
            Intent intent = new Intent(this, CallbackActivity.class);
            intent.putExtra("Str", "请输入How are you?");
            launcher1.launch(intent);
        });

        // 通过Intent调用其他应用
        Button toImageActivity = findViewById(R.id.toImageActivity);
        toImageActivity.setOnClickListener(view -> {
            Intent intent = new Intent(this, ChooseImage.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        textView.setText(item.getTitle());
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // 保存实例数据
        outState.putInt("counter", staCounter);
    }
}
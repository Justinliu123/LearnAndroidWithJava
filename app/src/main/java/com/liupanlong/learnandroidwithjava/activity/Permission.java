package com.liupanlong.learnandroidwithjava.activity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.liupanlong.learnandroidwithjava.R;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import cn.hutool.core.text.StrFormatter;

public class Permission extends AppCompatActivity {
    private ActivityResultLauncher<String[]> launcher = null;
    private TextView infoShow = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        // 注册授权回调
        launcher = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), result -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("权限回调函数被调用 \n");
            result.forEach((permission, enabled) -> {
                stringBuilder.append(StrFormatter.format("{} 是否被授予？ {} \n", permission, enabled));
            });
            infoShow.setText(stringBuilder.toString());
        });

        infoShow = findViewById(R.id.showPermission);
        Button searchPermission = findViewById(R.id.searchPermission);
        Button getPermission = findViewById(R.id.getPermission);

        getPermission.setOnClickListener(view -> requstPermissions());
        searchPermission.setOnClickListener(view -> showPermissionInfo());

    }

    private boolean hasCallPhonePermission() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED;
    }
    private boolean hasCameraPermission() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }
    private boolean hasBackgroundLocationPermission() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }
    private void requstPermissions() {
        List<String> permissionsToRequst = new ArrayList<>();
        if(!hasCallPhonePermission()) {
            permissionsToRequst.add(Manifest.permission.CALL_PHONE);
        }
        if(!hasCameraPermission()) {
            permissionsToRequst.add(Manifest.permission.CAMERA);
        }
        if(!hasBackgroundLocationPermission()) {
            permissionsToRequst.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION);
        }

        if(!permissionsToRequst.isEmpty()) {
            launcher.launch(permissionsToRequst.toArray(new String[permissionsToRequst.size()]));
        }
    }

    private void showPermissionInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StrFormatter.format("是否已经拥有打电话的权限：{}\n", hasCallPhonePermission()));
        stringBuilder.append(StrFormatter.format("是否已经拥有读取后台位置信息的权限：{}\n", hasBackgroundLocationPermission()));
        stringBuilder.append(StrFormatter.format("是否已经拥有使用摄像头的权限：{}\n", hasCameraPermission()));
        infoShow.setText(stringBuilder.toString());
    }
}
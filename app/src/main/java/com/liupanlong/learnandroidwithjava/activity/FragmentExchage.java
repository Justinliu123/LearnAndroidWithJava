package com.liupanlong.learnandroidwithjava.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.liupanlong.learnandroidwithjava.FristFragment;
import com.liupanlong.learnandroidwithjava.R;
import com.liupanlong.learnandroidwithjava.behavior.MyLifecycleObserver;
import com.liupanlong.learnandroidwithjava.others.ResponseToFragmentButtonClick;

import cn.hutool.core.text.StrFormatter;

public class FragmentExchage extends AppCompatActivity implements ResponseToFragmentButtonClick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_exchage);
        Fragment fragment = new com.liupanlong.learnandroidwithjava.fragment.FragmentExchage();
        getSupportFragmentManager().beginTransaction()
                // .addToBackStack(null) // 添加该语句支持回退，删除不支持
                .add(R.id.fragmentContainerToActivityInfo, fragment, "fragment1")
                .commit();

    }

    @Override
    public void responseToClick(Integer times) {
        TextView showFragmentInfoInActivity = findViewById(R.id.showFragmentInfoInActivity);
        showFragmentInfoInActivity.setText(String.valueOf(times));
    }
}
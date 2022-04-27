package com.liupanlong.learnandroidwithjava.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Button;

import com.liupanlong.learnandroidwithjava.FristFragment;
import com.liupanlong.learnandroidwithjava.R;

import cn.hutool.core.text.StrFormatter;

public class HaveFragmentActivity extends AppCompatActivity {

    private static int fragmentNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_have_fragment);
        // 如果activity中不存在Fragment则初始化fragmentNumber为0
        if(getSupportFragmentManager().findFragmentByTag("fragment1") == null)
            fragmentNumber = 0;

        Button addFragment = findViewById(R.id.addFragment);
        addFragment.setOnClickListener(view -> {
            Fragment fragment = FristFragment.newInstance(StrFormatter.format("Fragment {}", ++fragmentNumber),
                    "parama" + fragmentNumber, "paramb" + fragmentNumber);
            getSupportFragmentManager().beginTransaction()
                    // .addToBackStack(null) // 添加该语句支持回退，删除不支持
                    .add(R.id.fragmentContainerTimes, fragment, "fragment1")
                    .commit();
        });
        Button removeFragment = findViewById(R.id.removeFragment);
        removeFragment.setOnClickListener(view -> {
            Fragment fragment = getSupportFragmentManager().findFragmentByTag("fragment1");
            if(fragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .remove(fragment)
                        .commit();
                --fragmentNumber;
            }
        });
    }
}
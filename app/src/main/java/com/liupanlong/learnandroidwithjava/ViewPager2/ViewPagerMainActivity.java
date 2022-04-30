package com.liupanlong.learnandroidwithjava.ViewPager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.liupanlong.learnandroidwithjava.R;
import com.liupanlong.learnandroidwithjava.databinding.ActivityMainBinding;
import com.liupanlong.learnandroidwithjava.databinding.TopTabsBinding;

public class ViewPagerMainActivity extends AppCompatActivity {
    private TopTabsBinding binding;

    private Fragment[] fragments = new Fragment[]{new ViewPagerFragment1(1), new ViewPagerFragment1(2)};
    private String[] titles = new String[]{"消息", "通知"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = TopTabsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewPager2 viewPager = binding.textViewpager;// findViewById(R.id.textViewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this, fragments, titles);
        viewPager.setAdapter(adapter);

        TabLayout tabs = findViewById(R.id.textTabs);

        new TabLayoutMediator(tabs, viewPager, (tab, postion) -> {
            tab.setText(adapter.getPageTitle(postion));
        }).attach();
    }
}
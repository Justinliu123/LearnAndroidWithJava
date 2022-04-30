package com.liupanlong.learnandroidwithjava.ViewPager2;

import static cn.hutool.core.lang.Console.log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.liupanlong.learnandroidwithjava.R;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private Fragment[] fragments;
    public Integer NUM_PAGES = 2;
    public ViewPagerAdapter(@NonNull FragmentActivity fragment, Fragment[] fragments, String[] titles) {
        super(fragment);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        log("构造Fragment   " + position);
        return fragments[position];
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }

    public int getPageTitle(int postion) {
        int num = 0;
        switch (postion) {
            case 0:{
                num = R.string.tabs_message;
                break;
            }
            case 1: {
                num = R.string.tabs_notification;
                break;
            }
        }
        return num;
    }
}

package com.liupanlong.learnandroidwithjava.ViewPager2;

import static cn.hutool.core.lang.Console.log;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liupanlong.learnandroidwithjava.R;

public class ViewPagerFragment1 extends Fragment {
    private Integer number;

    public ViewPagerFragment1(Integer number) {
        log("构造一个新的Fragment  " + number);
        this.number = number;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_view_pager1, container, false);
        TextView viewPagerText = root.findViewById(R.id.viewPager1Text);
        viewPagerText.setText(String.valueOf(number));
        return root;
    }
}
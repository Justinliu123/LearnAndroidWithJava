package com.liupanlong.learnandroidwithjava.dataBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.liupanlong.learnandroidwithjava.R;
import com.liupanlong.learnandroidwithjava.databinding.ActivityDataBindingBinding;

public class DataBindingActivity extends AppCompatActivity {
    private ActivityDataBindingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        binding.setImageUrl("");
        binding.loadImage.setOnClickListener(view -> {
            binding.setImageUrl("https://img.win3000.com/m00/50/5c/9db53248acd950c611c6db3f64633b1e_c_224_336.jpg");
        });
    }
}
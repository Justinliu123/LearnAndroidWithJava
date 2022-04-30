package com.liupanlong.learnandroidwithjava.dataBinding;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

public class BindingAdapters {
    @BindingAdapter("showImage")
    public static void loadImage(ImageView view, String imageUrl) {
        if(imageUrl.isEmpty()) {
            return;
        }
        Glide.with(view.getContext()).load(imageUrl)
                .into(view);
    }
}

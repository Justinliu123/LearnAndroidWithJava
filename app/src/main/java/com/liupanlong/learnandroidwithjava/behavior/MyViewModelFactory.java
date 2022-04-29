package com.liupanlong.learnandroidwithjava.behavior;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MyViewModelFactory implements ViewModelProvider.Factory {
    public MyViewModelFactory() {
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(LiveDataTest.class)){
            return (T) new LiveDataTest();
        }
        return null;
    }
}

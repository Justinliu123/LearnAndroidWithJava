package com.liupanlong.learnandroidwithjava.behavior;

import static cn.hutool.core.lang.Console.log;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.liupanlong.learnandroidwithjava.R;

public class MyViewModel extends AndroidViewModel {
    private Application application;
    public LiveData<String> modeData;

    public MyViewModel(@NonNull Application application) {
        super(application)  ;
        this.application = application;
        modeData = new MutableLiveData(application.getString(R.string.background));
    }
    public void showToast(String massage) {
        Toast.makeText(application, massage, Toast.LENGTH_SHORT).show();
    }
}

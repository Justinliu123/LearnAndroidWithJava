package com.liupanlong.learnandroidwithjava.behavior;

import static cn.hutool.core.lang.Console.log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class LiveDataTest extends ViewModel {
    private MutableLiveData<Integer> counter;
    // 多监测源监测器
    private MediatorLiveData<String> mediatorLiveData =  new MediatorLiveData<>();

    public LiveDataTest() {
        counter = new MutableLiveData<>(0);

        mediatorLiveData.addSource(counter, (behavior) -> {
            log("counter值改变，触发行为" + behavior);
            mediatorLiveData.setValue(String.valueOf(behavior) + "_Mediator");
        });
        log("MyViewModel被创建");
    }

    // 将counter类型转为String
    public LiveData<String> showCounter = Transformations.map(counter, (in) -> {
        return String.valueOf(in);
    });

    public MediatorLiveData<String> getMediatorLiveData() {
        return mediatorLiveData;
    }

    public void setMediatorLiveData(MediatorLiveData<String> mediatorLiveData) {
        this.mediatorLiveData = mediatorLiveData;
    }

    public MutableLiveData<Integer> getCounter() {
        return counter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        log("MyViewModel已被销毁");
    }
}

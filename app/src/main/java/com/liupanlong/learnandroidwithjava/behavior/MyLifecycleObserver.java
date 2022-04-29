package com.liupanlong.learnandroidwithjava.behavior;

import static cn.hutool.core.lang.Console.log;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

import java.util.Timer;
import java.util.TimerTask;

public class MyLifecycleObserver implements LifecycleEventObserver {

    private LiveDataTest counterOjb = null;
    Timer timer = null;
    private Thread thread = null;
    public MyLifecycleObserver() {
    }

    public MyLifecycleObserver(LiveDataTest counterOjb) {
        this.counterOjb = counterOjb;
    }

    @Override
    public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
        switch(event) {
            case ON_CREATE:{
                log("MyLifecycleObserver:onCreate");
                // 起一个线程
                /*thread = new Thread(() -> {
                    try {
                        while (true) {
                            Thread.sleep(1000);
                            counterOjb.counter.postValue(counterOjb.counter.getValue() + 1);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                thread.start();*/
                break;
            }
            case ON_START:{
                log("MyLifecycleObserver:onStart");
                this.timer = new Timer();
                this.timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        counterOjb.getCounter().postValue(counterOjb.getCounter().getValue() + 1);
                    }
                }, 0, 1000 );
                break;
            }
            case ON_STOP:{
                this.timer.cancel();
            }
            case ON_DESTROY:{
                if(thread != null || timer != null) {
                    thread = null;
                    timer = null;
                }
                break;
            }
        }

    }


}

package com.liupanlong.learnandroidwithjava;

import android.app.Application;

import com.liupanlong.learnandroidwithjava.websocketTest.MyWebSocketClient;

import java.net.URI;
import java.net.URISyntaxException;

public class MyApplication extends Application {
    public static MyWebSocketClient webSocketClient;
    public MyApplication() {
        System.out.println("启动MyApplication");
        webSocketClient = new MyWebSocketClient(URI.create("ws://192.168.43.200:9001/ws"));
    }
}

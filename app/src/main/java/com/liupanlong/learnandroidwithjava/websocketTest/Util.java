package com.liupanlong.learnandroidwithjava.websocketTest;

import android.content.Context;
import android.widget.Toast;

public class Util {
    public static final String ws = "ws://192.168.43.200:9001/ws"; //websocket测试地址

    public static void showToast(Context ctx, String msg) {
        Toast.makeText(ctx, msg, Toast.LENGTH_LONG).show();
    }
}

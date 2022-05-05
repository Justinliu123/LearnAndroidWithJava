package com.liupanlong.learnandroidwithjava.websocketTest;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;


public class MyWebSocketClient extends WebSocketClient {
    public MyWebSocketClient(URI serverUri) {
        super(serverUri);
    }

    //在webSocket连接开启时调用
    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("连接建立成功");
    }

    //接收到消息时调用
    @Override
    public void onMessage(String message) {
        System.out.println("接收消息" + message);
    }

    //在连接断开时调用
    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("连接关闭");
    }

    //在连接出错时调用
    @Override
    public void onError(Exception ex) {
        System.out.println("发送异常");
    }
}

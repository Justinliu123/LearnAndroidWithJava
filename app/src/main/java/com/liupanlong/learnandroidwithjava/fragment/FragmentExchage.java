package com.liupanlong.learnandroidwithjava.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.liupanlong.learnandroidwithjava.R;
import com.liupanlong.learnandroidwithjava.others.ResponseToFragmentButtonClick;

import java.time.LocalTime;

public class FragmentExchage extends Fragment {
    private ResponseToFragmentButtonClick listener;
    private static int counter;
    private Button sendInfoToActivity;
    private Context inContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_exchage, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sendInfoToActivity = view.findViewById(R.id.sendInfoToActivity);
        sendInfoToActivity.setOnClickListener(view1 -> {
            if(listener != null)
                listener.responseToClick(++counter);
            else {
                Toast.makeText(inContext, "不支持消息传递！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        inContext = context;
        if(context instanceof ResponseToFragmentButtonClick) {
            listener = (ResponseToFragmentButtonClick) context;
        }
    }
}
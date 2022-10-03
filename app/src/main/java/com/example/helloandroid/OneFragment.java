package com.example.helloandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.Nullable;

public class OneFragment extends Fragment {
    private final  String address = "https://baike.sogou.com/v53328386.htm?fromTitle=%E9%A5%AE%E9%A3%9F%E5%81%A5%E5%BA%B7";
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(container.getContext());
        textView.setText("第一个页面,实现网页中饮食搭配的抓取");
        return  textView;
    }
}

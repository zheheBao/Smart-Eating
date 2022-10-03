package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class Activity_okhttp_feng extends AppCompatActivity {

    //1.定义字符串变量，用来存放给定的目标网络地址
    private final  String address = "https://baike.sogou.com/v53328386.htm?fromTitle=%E9%A5%AE%E9%A3%9F%E5%81%A5%E5%BA%B7";

    //2.定义Text View对象
    private TextView T_11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_feng);

        T_11 = findViewById(R.id.T_1);

        //调用工具栏HttpUtil工具类的sendOkHttpRequest()方法，抓取网络数据并进行处理
        HttpUtil.sendOkHttpRequest(address,new okhttp3.Callback(){

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                //1.定义一个变量，用来接收服务器返回的数据
                final String responseData = response.body().string();
                //2.通过runOnUiThread()进行线程切换
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //完成UI操作
                        T_11.setText(responseData);
                    }
                });
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }
        });
    }
}

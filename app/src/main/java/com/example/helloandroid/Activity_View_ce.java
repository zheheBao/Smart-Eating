package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Activity_View_ce extends AppCompatActivity {

    TextView textView_11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ok);

        //将TextView对象和布局文件中的控件进行关联
        textView_11 = findViewById(R.id.tv);

        //1.创建OkHttpClient类的实例
        OkHttpClient client = new OkHttpClient();

        //2.创建Request对象，并设置目标网络地址、请求方式等
        Request request = new Request.Builder()
                .url("https://baike.sogou.com/v53328386.htm?fromTitle=%E9%A5%AE%E9%A3%9F%E5%81%A5%E5%BA%B7")
                .get()
                .build();
        //3.通过前面定义的OkHttpClient对象来调用newCall()方法创建call对象
        Call call = client.newCall(request);

        //4.发起请求并获取服务器返回的数据（异步）
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                //服务器访问失败时的处理操作
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                //接受并处理从服务器返回的数据
                String responseData = response.body().string();
                showResponse(responseData);
            }
        });

    }

    private void showResponse(final String responseData) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //在这里进行UI操作，将结果显示到界面上
                textView_11.setText(responseData);
            }
        });

    }
}
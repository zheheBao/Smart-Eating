package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class Activity_json extends AppCompatActivity {

    //1.定义一个字符串变量，用来存放HTTP请求的网络地址
    public static final String address = "http://v.juhe.cn/weather/index?format=2&cityname=%E8%8B%8F%E5%B7%9E&key=ccfadb3491e63c1c3556f3ceb19e1237";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        //2.调用工具类的sendOkHttpRequest()方法，获取服务器返回的天气信息
        HttpUtil.sendOkHttpRequest(address,new okhttp3.Callback(){
            //重写抽象方法
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                //获取服务器返回的数据
                String responseData = response.body().string();
                //通过Postman可以看出，未来7天的天气信息存放在索引值为future的JSON数组中
                try{
                    JSONObject jsonObject = new JSONObject(responseData);
                    JSONObject jsonData = jsonObject.getJSONObject("result");
                    JSONArray jsonArray = jsonData.getJSONArray("future");
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject partFuture = jsonArray.getJSONObject(i);
                        String temperature = partFuture.getString("temperature");
                        String weather = partFuture.getString("weather");
                        String wind = partFuture.getString("wind");
                        String week = partFuture.getString("week");
                        String date = partFuture.getString("date");
                        Log.d("MainActivity","temperature:"+temperature+" "+"weather:"+weather+" "+"wind:"+wind+" "+"week:"+week+" "+"date:"+date);
                    }

                }catch (Exception e){

                }

            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }
        });
    }
}
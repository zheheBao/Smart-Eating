package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class Activity_gson extends AppCompatActivity {

    //1.定义一个字符串变量，用来存放HTTP请求的地址
    public static final String address = "http://v.juhe.cn/weather/index?format=2&cityname=苏州&key=ccfadb3491e63c1c3556f3ceb19e1237";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        //2.调用工具类的sendOkHttpRequest()方法，获取服务器返回的天气信息

        //目标地址和抽象地址
        HttpUtil.sendOkHttpRequest(address,new okhttp3.Callback(){


            //抽象操作类有成功和失败

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                //定义一个字符串变量responseData，存放服务器返回的json数据
                String responseData = response.body().string();
                //创建GSON类的对象
                Gson gson = new Gson();
                //调用fromJson()方法将json字符串转换为Java实体类的对象
                JsonToBean jsonToBean = gson.fromJson(responseData,new TypeToken<JsonToBean>(){}.getType());
                //后面的操作就是Java类的操作了
                JsonToBean.ResultBean resultBean = jsonToBean.getResult();
                List<JsonToBean.ResultBean.FutureBean> futureBeanList = resultBean.getFuture();
                for(int i=0 ;i<futureBeanList.size();i++){
                    JsonToBean.ResultBean.FutureBean futureBean = futureBeanList.get(i);
                    Log.d("MainActivity","temperature:"+futureBean.getTemperature()+" "+"weather:"+futureBean.getWeather()+" "+"wind:"+futureBean.getWind()+" "+"week:"+futureBean.getWeek()+"date:"+futureBean.getDate());
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }
        });
    }
}

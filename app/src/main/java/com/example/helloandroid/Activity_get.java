package com.example.helloandroid;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.http.params.CoreConnectionPNames;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Activity_get extends AppCompatActivity {
    private static final int SUCCESS = 0;
    private static final int FAILURE = 1;
    private EditText et;
    private Button btn;
    private Button btnPost;
    private String txt;
    //统一资源定位器URL字符串，192.168.43.182为服务器地址
    String stringURL = "http://192.168.43.182:8080/AndroidTest/Message.txt";

    private Handler mHandler = new Handler(){
        //重写handleMessage方法
        public void handleMessage (Message msg){
            switch(msg.what) {
                case SUCCESS:
                    et.setText(txt);
                    break;
                case FAILURE:
                    et.setText("Download the file Failure!");
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
        et = (EditText)findViewById(R.id.editText);
        btn = (Button)findViewById(R.id.button);

        //为按钮添加事件监听器
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetURLResources();
            }
        });

    }
    public void GetURLResources(){
//创建一个新线程，读取服务器资源
        new Thread(new Runnable(){
            public void run(){
                try{
                    URL myUrl = new URL(stringURL);
                    //创建一个HttpURLConnection对象，打开链接
                    HttpURLConnection myConn =(HttpURLConnection)myUrl.openConnection();
                    //设置连接超时
                    myConn.setConnectTimeout(3000);
                    //获取输入流，得到读取的内容
                    InputStreamReader in = new InputStreamReader(myConn.getInputStream());
                    BufferedReader buffer = new BufferedReader(in);
                    String inputLine = null;
                    StringBuffer pageBuffer = new StringBuffer();
                    while((inputLine = buffer.readLine())!= null){
                        pageBuffer.append(inputLine +"\n");
                    }
                    //设置字符的编码格式
                    txt =  new String(pageBuffer.toString().getBytes("UTF-8"));
                    //去掉最后一行的换行符
                    txt = txt.substring(0,txt.length()-1);
                    mHandler.sendEmptyMessage(0);
                    in.close();
                    buffer.close();
                    //关闭连接
                    myConn.disconnect();
                }
                catch(Exception e){
                    mHandler.sendEmptyMessage(1);
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
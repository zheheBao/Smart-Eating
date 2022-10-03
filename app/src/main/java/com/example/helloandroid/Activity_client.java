package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;

import java.io.InputStream;

public class Activity_client extends AppCompatActivity {
    private static final int SUCCESS = 0;
    private static final int FAILURE = 1;
    private Button btn;
    private TextView tv;
    private ImageView iv;
    //5_23成功访问服务器图片

    //统一资源定位器URL字符串
    //String stringURL = "http://192.168.43.182:8080/AndroidTest/Success.jpg";http://192.168.43.182:8080/Tomcat_resourse/small_1.jpg
    String stringURL = "http://192.168.43.182:8080/AndroidUpload/Success.jpg";
    private Handler mHandler = new Handler(){
        //重写handleMessage方法
        public void handleMessage (Message msg) {
            switch(msg.what) {
                case SUCCESS:
                    tv.setText("Download the Picture Success!");
                    //设置图片控件中显示的图片对象
                    iv.setImageBitmap((Bitmap) msg.obj);
                    break;
                case FAILURE:
                    tv.setText("Download the Picture Failure!");
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        btn = (Button)findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView);
        iv = (ImageView)findViewById(R.id.imageView);
        //为按钮添加事件监听器
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetURLResources();
            }
        });
    }
    public void GetURLResources(){
        new Thread(new Runnable(){
            public void run(){
                try{
                    HttpClient httpclient = new DefaultHttpClient();	//创建httpclient对象
                    HttpGet httpGet = new HttpGet(stringURL);		//创建连接
                    httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 3000);								//设置超时
                    HttpResponse httpresponse = httpclient.execute(httpGet); //执行GET请求
                    //判断连接状态
                    if(httpresponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                        HttpEntity httpentity = httpresponse.getEntity(); 	//获取响应实体
                        InputStream in = httpentity.getContent(); 		//获取输入流
                        Bitmap bmp = BitmapFactory.decodeStream(in);
                        mHandler.obtainMessage(0, bmp).sendToTarget(); //发送包含对象的消息
                        in.close();
                    }
                }
                catch(Exception e){
                    mHandler.obtainMessage(1).sendToTarget();		//连接服务器失败消息
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

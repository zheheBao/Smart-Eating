package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/*
public class Activity_socket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket);
    }
}

 */
public class Activity_socket extends AppCompatActivity {
    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket);

        et = (EditText)findViewById(R.id.editText);		//获得EditText对象
        new Thread(new Runnable() {
            public void run() {
                try{
                    Socket socket = new Socket("192.168.43.182", 5678); //创建Socket对象
                    //获得输出流
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    out.writeUTF("This is a Message Send by Client !");  //发送信息out.flush();
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    String str = in.readUTF();				//读取服务端发来的消息
                    et.setText(str);						//设置EditText对象
                    out.close();
                    in.close();
                    socket.close();						//关闭Socket
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
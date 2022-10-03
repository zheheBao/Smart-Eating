package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Activity_zhineng extends AppCompatActivity {

    EditText edi_11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhineng);

        //接受值传递

        edi_11=findViewById(R.id.edi_1);
        //可以展示多个推荐的内容，例如食物推荐，推荐的原因

        /*
        String str1= getIntent().getStringExtra("aa");

        edi_11.setText(str1);


         */


        FileInputStream fin = null;
        try {
            fin = openFileInput("abc.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[]   arr= new byte[0];
        try {
            arr = new byte[fin.available()];
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fin.read(arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //方法可行，采用

        String st=new String(arr);
        Double in=Double.parseDouble(st);

        if(in>20){
            edi_11.setText("食物G   食物H");
        }
        else if(in<10){
            edi_11.setText("食物A   食物B ");
        }
        else{
            edi_11.setText("食物D   食物E ");
        }



       // edi_11.setText(new  String(arr));




    }
}
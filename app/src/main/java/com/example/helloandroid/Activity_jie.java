package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Activity_jie extends AppCompatActivity {


    EditText txt_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie);

        txt_1=findViewById(R.id.Ed_1);

        try {
            FileInputStream fin =openFileInput("abc.txt");
            byte[]   arr=new byte[fin.available()];
            fin.read(arr);
            fin.close();
            txt_1.setText(new String(arr));




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Time time=new Time();
        time.setToNow();
        txt_1.append("\n\n"+time.year+"年"+(time.month+1)+"月"+time.monthDay+"日"+"\n");

    }
}
package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_test extends AppCompatActivity {

    Button B_1;
    Button B_2;
    Button B_3;
    Button B_4;
    Button B_5;
    Button B_6;
    Button B_7;
    Button B_8;
    Button B_9;
    Button B_10;
    Button B_11;
    Button B_12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        B_1 = findViewById(R.id.btn_1);
        B_2 = findViewById(R.id.btn_2);
        B_3 = findViewById(R.id.btn_3);
        B_4 = findViewById(R.id.btn_4);
        B_5 = findViewById(R.id.btn_5);
        B_6 = findViewById(R.id.btn_6);
        B_7 = findViewById(R.id.btn_7);
        B_8 = findViewById(R.id.btn_8);
        B_9 = findViewById(R.id.btn_9);
        B_10 = findViewById(R.id.btn_10);
        B_11= findViewById(R.id.btn_11);
        B_12= findViewById(R.id.btn_12);

        B_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Activity_test.this,Activity_get.class);

                startActivity(intent);
            }
        });

        B_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Activity_test.this,Activity_client.class);

                startActivity(intent);
            }
        });

        B_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Activity_test.this,Activity_socket.class);

                startActivity(intent);
            }
        });

        B_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Activity_test.this,Activity_web.class);

                startActivity(intent);
            }
        });

        B_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Activity_test.this,Activity_down_file.class);

                startActivity(intent);
            }
        });




    }
}
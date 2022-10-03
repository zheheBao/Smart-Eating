package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_view_pro extends AppCompatActivity {


    //测试主页面
    Button But_11;
    Button But_22;
    Button But_33;
    Button But_44;
    Button But_55;
    Button But_66;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity__view_ce);
        But_11 = findViewById(R.id.But_1);

        But_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Activity_view_pro.this,Activity_View_ce.class);


                startActivity(intent);
            }
        });


        But_22 = findViewById(R.id.But_2);

        But_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Activity_view_pro.this,Activity_okhttp_feng.class);


                startActivity(intent);
            }
        });

        But_33 = findViewById(R.id.But_3);

        But_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Activity_view_pro.this,Activity_json.class);

                startActivity(intent);
            }
        });


        But_44 = findViewById(R.id.But_4);

        But_44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Activity_view_pro.this,Activity_gps_ce.class);

                startActivity(intent);
            }
        });



        But_55 = findViewById(R.id.But_5);

        But_55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Activity_view_pro.this,Activity_gps_setting.class);

                startActivity(intent);
            }
        });

        But_66 = findViewById(R.id.But_6);

        But_66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Activity_view_pro.this,Activity_test.class);

                startActivity(intent);
            }
        });

    }
}
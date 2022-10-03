package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_judge extends AppCompatActivity {


    TextView txt_1,txt_3,txt_4;
    ImageView ima_1;
    Button Bu_1,Bu_2,Bu_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_judge);


        txt_1=findViewById(R.id.textview_judge_1);

        int year1 = getIntent().getIntExtra("year",0);
        int month1 = getIntent().getIntExtra("month",0);
        int day1 = getIntent().getIntExtra("day",0);
        int month2=month1+1;

        txt_1.setText(year1+"年"+month2+"月"+day1+"日");


        //int []imgarr={R.drawable.p2,R.drawable.p3};
        //int []contentarr={R.string.辣,R.string.肉类};

        //进行连接图片的识别下标传递---


       // Bu_1.
        Bu_1=findViewById(R.id.textview_judge_5);
        Bu_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Activity_judge.this,Activity_geren.class);
                startActivity(intent);
            }
        });

        Bu_2=findViewById(R.id.textview_judge_6);
        Bu_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent(Activity_judge.this,Activity_dapei.class);
                startActivity(intent1);
            }
        });


        Bu_3=findViewById(R.id.textview_judge_7);
        Bu_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(Activity_judge.this,Activity_shai.class);
                startActivity(intent2);
            }
        });




    }

}
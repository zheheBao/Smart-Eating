package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_in extends AppCompatActivity {

    TextView txt_1,txt_7;
    Button txt_3;
    Button txt_6;
    ImageView txt_4;
    DatePicker txt_5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in);

        txt_1=findViewById(R.id.textview_in_1);

        txt_7=findViewById(R.id.textview_in_7);

        //实现推送的语句1
        String str1= getIntent().getStringExtra("aa");

        txt_1.setText(str1);

        txt_3=findViewById(R.id.textview_in_3);

        txt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent intent =new Intent(Activity_in.this,Activity_judge.class);
                txt_4.setImageResource(R.drawable.p3);
                txt_7.setText("你选择的美食为编号：2");
                //intent.putExtra()
             //   startActivity(intent);
            }
        });



        txt_6=findViewById(R.id.textview_in_6);
        txt_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Activity_in.this,Activity_judge.class);

                intent.putExtra("year",txt_5.getYear());
                intent.putExtra("month",txt_5.getMonth());
                intent.putExtra("day",txt_5.getDayOfMonth());


                startActivity(intent);
            }
        });

        txt_4=findViewById(R.id.textview_in_4);





        txt_5=findViewById(R.id.textview_in_5);







    }
}
package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity_geren extends AppCompatActivity {


    Button Butt_1;
    Button Butt_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geren);


        Butt_1=findViewById(R.id.textview_geren_1);
        Butt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_geren.this,"成功进入喜好搭配log界面",Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(Activity_geren.this,Activity_xihao.class);
                startActivity(intent);
            }
        });


        Butt_2=findViewById(R.id.textview_geren_2);
        Butt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_geren.this,"成功进入饮食设置界面",Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(Activity_geren.this,Activity_shezhi.class);
                startActivity(intent);
            }
        });



    }
}
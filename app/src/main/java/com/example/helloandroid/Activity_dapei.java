package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity_dapei extends AppCompatActivity {


    Button Bu_dapei1;
    Button Bu_dapei2;
    Button Bu_dapei3;
    Button Bu_dapei4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dapei);


        // Bu_1.
        Bu_dapei1=findViewById(R.id.textview_dapei_1);
        Bu_dapei1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_dapei.this,"成功进入搭配分析界面",Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(Activity_dapei.this,Activity_da_dn.class);
                startActivity(intent);
            }
        });

        Bu_dapei2=findViewById(R.id.textview_dapei_2);
        Bu_dapei2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_dapei.this,"成功进入搭配分析界面",Toast.LENGTH_SHORT).show();
                Intent intent1 =new Intent(Activity_dapei.this,Activity_da_syt.class);
                startActivity(intent1);
            }
        });


        Bu_dapei3=findViewById(R.id.btn_in);
        Bu_dapei3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_dapei.this,"成功进入搭配记录查看界面",Toast.LENGTH_SHORT).show();
                Intent intent1 =new Intent(Activity_dapei.this,Activity_jie.class);
                startActivity(intent1);
            }
        });

        Bu_dapei4=findViewById(R.id.btn_2);
        Bu_dapei4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_dapei.this,"成功进入智能搭配查看界面",Toast.LENGTH_SHORT).show();
                Intent intent1 =new Intent(Activity_dapei.this,Activity_zhineng.class);
                startActivity(intent1);
            }
        });

    }
}
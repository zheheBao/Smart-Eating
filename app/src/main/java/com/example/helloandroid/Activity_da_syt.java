package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_da_syt extends AppCompatActivity {
    //定义对象
    TextView txt_result1;
    Button btn_71;
    Button btn_81;
    Button btn_91;
    Button btn_jia1;
    Button btn_41;
    Button btn_51;
    Button btn_61;
    //Button btn_jian1;
    Button btn_11;
    Button btn_21;
    Button btn_31;
    // Button btn_cheng1;
    //Button btn_01;
    Button btn_qing1;
    Button btn_deng1;
    //Button btn_chu1;
    double num1=0,num2=0;//声明两个参数，接受数据
    double result=0;//运算结果
    Boolean isClickdeng=false;//判断是否单击了=号
    String op="%";//操作符+-*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_da_syt);
        //绑定控件
        txt_result1=findViewById(R.id.txt_result);
        btn_71 = findViewById(R.id.btn_7);
        btn_81 = findViewById(R.id.btn_8);
        btn_91 =  findViewById(R.id.btn_9);
        btn_jia1 =  findViewById(R.id.btn_jia);
        btn_41 =  findViewById(R.id.btn_4);
        btn_51 =  findViewById(R.id.btn_5);
        btn_61 =  findViewById(R.id.btn_6);
        //btn_jian1 =  findViewById(R.id.btn_jian);
        btn_11 =  findViewById(R.id.btn_1);
        btn_21 =  findViewById(R.id.btn_2);
        btn_31 =  findViewById(R.id.btn_3);
        //btn_cheng1 =  findViewById(R.id.btn_cheng);
        //btn_01 =  findViewById(R.id.btn_0);
        btn_qing1 =  findViewById(R.id.btn_qing);
        btn_deng1 =  findViewById(R.id.btn_deng);
        //btn_chu1 =  findViewById(R.id.btn_chu);
        //按钮的单击事件
        btn_71.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                //按钮单击逻辑
                if(isClickdeng){//说明刚单击了=，上一个运算刚结束
                    txt_result1.setText("");//重新计算，文本框清空
                    isClickdeng=false;
                }
                txt_result1.setText(txt_result1.getText().toString()+"7");
            }
        });
        btn_81.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //按钮单击逻辑
                if(isClickdeng){//说明刚单击了=，上一个运算刚结束
                    txt_result1.setText("");//重新计算，文本框清空
                    isClickdeng=false;
                }
                txt_result1.setText(txt_result1.getText().toString()+"8");
            }
        });
        btn_91.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //按钮单击逻辑
                if(isClickdeng){//说明刚单击了=，上一个运算刚结束
                    txt_result1.setText("");//重新计算，文本框清空
                    isClickdeng=false;
                }
                txt_result1.setText(txt_result1.getText().toString()+"9");
            }
        });

        btn_jia1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st1=txt_result1.getText().toString();//获取点了加号之前字符串类型的数据
                if(st1.equals("")){
                    return;
                }
                num1=Double.parseDouble(st1);
                txt_result1.setText("");
                op="+";
                isClickdeng=false;
            }
        });
        btn_41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //按钮单击逻辑
                if(isClickdeng){//说明刚单击了=，上一个运算刚结束
                    txt_result1.setText("");//重新计算，文本框清空
                    isClickdeng=false;
                }
                txt_result1.setText(txt_result1.getText().toString()+"4");
            }
        });
        btn_51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //按钮单击逻辑
                if(isClickdeng){//说明刚单击了=，上一个运算刚结束
                    txt_result1.setText("");//重新计算，文本框清空
                    isClickdeng=false;
                }
                txt_result1.setText(txt_result1.getText().toString()+"5");
            }
        });
        btn_61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //按钮单击逻辑
                if(isClickdeng){//说明刚单击了=，上一个运算刚结束
                    txt_result1.setText("");//重新计算，文本框清空
                    isClickdeng=false;
                }
                txt_result1.setText(txt_result1.getText().toString()+"6");
            }
        });

        btn_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //按钮单击逻辑
                if(isClickdeng){//说明刚单击了=，上一个运算刚结束
                    txt_result1.setText("");//重新计算，文本框清空
                    isClickdeng=false;
                }
                txt_result1.setText(txt_result1.getText().toString()+"1");
            }
        });
        btn_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //按钮单击逻辑
                if(isClickdeng){//说明刚单击了=，上一个运算刚结束
                    txt_result1.setText("");//重新计算，文本框清空
                    isClickdeng=false;
                }
                txt_result1.setText(txt_result1.getText().toString()+"2");
            }
        });
        btn_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //按钮单击逻辑
                if(isClickdeng){//说明刚单击了=，上一个运算刚结束
                    txt_result1.setText("");//重新计算，文本框清空
                    isClickdeng=false;
                }
                txt_result1.setText(txt_result1.getText().toString()+"3");
            }
        });

        btn_qing1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_result1.setText("");
            }
        });
        btn_deng1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str2=txt_result1.getText().toString();
                if(str2.equals("")){
                    return;
                }
                num2=Double.parseDouble(str2);
                txt_result1.setText("");
                switch (op){
                    case "+":result=num1+num2;break;
                    case "%":result=num2;break;
                    default:result=0.0;break;
                }
                txt_result1.setText(result+"");
                op="%";
                isClickdeng=true;
            }
        });

    }
}

package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //TextView textView_11;
    //TextView textView_22;

    Button textView_33;
    Button textView_99;
    //ImageView textView_44;
    EditText textView_55;
    EditText textView_77;

    Button textView_66;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textView_11=findViewById(R.id.textview_1);
        //textView_22=findViewById(R.id.textview_2);

        //textView_11.setTextSize(20);
        //textView_11.setTextColor(Color.rgb(255,100,0));

       // String str1= textView_22.getText().toString();
        //textView_11.setText(str1+" 如下：");


        textView_33=findViewById(R.id.textview_3);

        //textView_55=findViewById(R.id.textview_5);
        textView_77=findViewById(R.id.textview_7);

        textView_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_33.setText("您已登录");
                Intent intent=new Intent(MainActivity.this,Activity_in.class);

                intent.putExtra("aa",textView_77.getText().toString());

                startActivity(intent);
            }
        });

        //textView_44=findViewById(R.id.textview_4);

        textView_66=findViewById(R.id.textview_6);
        //textView_66.setOnClickListener(new View.OnClickListener() {
           /* @Override
            public void onClick(View v) {
                textView_44.setImageResource(R.drawable.p2);
            }

        });
*/
        textView_99=findViewById(R.id.textview_9);

        textView_99.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,Activity_lian.class);

                startActivity(intent);
            }
        });

        //测试按钮
        textView_66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,Activity_view_pro.class);


                startActivity(intent);
            }
        });




    }
}
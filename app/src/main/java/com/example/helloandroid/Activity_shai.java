package com.example.helloandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.blankj.utilcode.util.UriUtils;
import com.bumptech.glide.Glide;

import java.io.File;
import java.io.IOException;

public class Activity_shai extends AppCompatActivity {

    private static final String TAG = "Activity_shai";
    //定义对象
    ImageView img_camer,img_photo;
    Button btn_camer,btn_photo;
    //定义一个路径： 1 拍照的临时路径，2 显示照片的最终路径
    String tmp_path,disp_path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shai);

        //手动开启程序权限之后，拍照仍闪退，解决拍照闪退问题
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }


        //第一步：绑定控件
        initView();
        //第二步：拍照按钮单击事件
        btnCamOnclick();

        //第三步：拍完照之后，接收照片并显示  系统回调  打开相册，选择照片 系统回调

        //第四步：打开相册按钮单击事件
        btnPhoOnclick();

    }

    //第一步：绑定控件
    private void initView() {
        img_camer=findViewById(R.id.imageView_cam);
        btn_camer=findViewById(R.id.button_cam);
        img_photo=findViewById(R.id.imageView_photo);
        btn_photo=findViewById(R.id.button_photo);
    }


    //第二步：拍照按钮单击事件
    private void btnCamOnclick() {
        btn_camer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick:1 "+"单击了按钮");

                tmp_path= Environment.getExternalStorageDirectory()+"/img_"+randFileName()+".jpg";
                File imgfile=new File(tmp_path);//创建保存照片的文件，照片都保存到本路径下
                try {
                    if(imgfile.exists()){
                        imgfile.delete();
                    }
                    imgfile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //1创建一个打开相机的Intent
                Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
                //2 告诉相机图片的保存位置,Uri统一文件标识符
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imgfile));
                //3 打开相机
                startActivityForResult(intent,11);

            }
        });
    }

    //第四步：打开相册按钮单击事件------代码
    private void btnPhoOnclick() {
        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //打开相册代码
                //创建打开相册的Intent
                Intent intent=new Intent("android.intent.action.GET_CONTENT");
                //打开页面的类型
                intent.setType("image/*");
                //打开相册
                startActivityForResult(intent,22);

            }
        });
    }



    //第三步：拍完照之后，接收照片并显示  系统回调


    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 11:
                if (resultCode==RESULT_OK){
                    //根据照片的真实路径来显示照片
                    disp_path=tmp_path;//确定图片的路径
                    //显示照片
                    Glide.with(Activity_shai.this).load(disp_path).into(img_camer);
                }
                break;
            case 22:
                if(resultCode==RESULT_OK){
                    //根据选择照片的路径，显示照片
                    Uri imageuri=data.getData();//这是一个缩略图
                    if (imageuri==null){
                        return;
                    }
                    disp_path= UriUtils.uri2File(imageuri).getPath();//将缩略图转化为真实的图片路径
                    Glide.with(Activity_shai.this). load(  disp_path ).into(img_photo);
                }
                break;
            default:

                break;
        }
    }

    // 时间戳，为了保证每次拍的照片都能以不同的文件名保存到sd卡上。
    private String randFileName(){
        Time t=new Time();
        t.setToNow();// 取得系统时间。
        String  strtime=t.year+""+(t.month+1)+""+t.monthDay+""+t.hour+""+t.minute+""+t.second+"";
        return strtime;
    }
}
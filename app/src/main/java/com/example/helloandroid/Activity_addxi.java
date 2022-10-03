package com.example.helloandroid;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.UriUtils;
import com.bumptech.glide.Glide;
import com.example.helloandroid.db.MyDbHelper;

import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;

public class Activity_addxi extends AppCompatActivity {
    //定义对象
    EditText edit_title,edit_content;
    Button btn_camera,btn_photo,btn_save;
    ImageView img_preview;
    String tmp_path,disp_path;
    MyDbHelper mhelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addxi);


        //手动开启程序权限之后，拍照仍闪退，解决拍照闪退问题
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }

        //1 绑定控件
        initView();

        //2 单击按钮、拍照、从图库中选择照片
        btnOnClick();

        //3 接受拍好照片、接受从图库当中选择的照片 方法：系统回调

        //4 把信息保存到数据库中
        btnSave();
    }


    //1 绑定控件-----代码
    private void initView() {
        edit_title=findViewById(R.id.editText_title);
        edit_content=findViewById(R.id.editText_content);
        btn_camera=findViewById(R.id.button_camera);
        btn_photo=findViewById(R.id.button_photo);
        img_preview=findViewById(R.id.imageView_preview);
        btn_save=findViewById(R.id.button_save);
        mhelper=new MyDbHelper(Activity_addxi.this);
        db= mhelper.getWritableDatabase();
    }


    //2 单击按钮、拍照
    private void btnOnClick() {
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //拍照
                Time time=new Time();
                time.setToNow();
                String randtime=time.year+(time.month+1)+time.monthDay+time.hour+time.minute+time.second+"";
                tmp_path= Environment.getExternalStorageDirectory()+"/image"+ randtime+".jpg";
                File imgfile=new File(tmp_path);
                try {
                    imgfile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imgfile) );
                startActivityForResult(intent,11);

            }
        });
        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //选择照片
                Intent intent=new Intent("android.intent.action.GET_CONTENT");
                intent.setType("image/*");
                startActivityForResult(intent,22);
            }
        });
    }


    //3 接受拍好照片、接受从图库当中选择的照片 ------方法：系统回调

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 11:
                if (resultCode == RESULT_OK) {
                    disp_path = tmp_path;
                    Glide.with(Activity_addxi.this).load(disp_path).into(img_preview);
                }
                break;
            case 22:
                Uri imageuri = data.getData();
                if (imageuri == null) {
                    return;
                }
                disp_path = UriUtils.uri2File(imageuri).getPath();
                Glide.with(Activity_addxi.this).load(disp_path).into(img_preview);
                break;
            default:
                break;
        }
    }

    //4 把信息保存到数据库中
    private void btnSave() {
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //保存信息到数据库代码
                Time time=new Time();
                time.setToNow();
                ContentValues contentValues=new ContentValues();//一行
                contentValues.put("title",edit_title.getText().toString());//1行——1列
                contentValues.put("content",edit_content.getText().toString());//1行——3列
                contentValues.put("imgpath",disp_path);
                contentValues.put("mtime",time.year+"/"+(time.month+1)+"/"+time.monthDay);
                db.insert("tb_memory",null,contentValues);
                Toast.makeText(Activity_addxi.this,"保存成功",Toast.LENGTH_SHORT).show();

                //跳转到主界面
                Intent intent=new Intent(Activity_addxi.this,Activity_xihao.class);
                startActivity(intent);
                finish();
            }
        });
    }

}

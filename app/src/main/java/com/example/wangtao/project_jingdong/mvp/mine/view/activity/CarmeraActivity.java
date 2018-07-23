package com.example.wangtao.project_jingdong.mvp.mine.view.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.mvp.homepage.model.adapter.RectcleTuijianAdapter;

import java.io.File;

/**
 * Created by wangtao on 2018/7/17.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class CarmeraActivity extends AppCompatActivity {
  /*  private ImageView imageView;
    private Button btn1,btn2;
    private String path= Environment.getExternalStorageDirectory()+"/camera.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取组件
        imageView=(ImageView) findViewById(R.id.main_image);
        btn1=(Button) findViewById(R.id.main_btn1);
        btn2=(Button) findViewById(R.id.main_btn2);
        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //打开相机
                Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //将图片存入sdcard
                intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(new File(path)));
                startActivityForResult(intent, 1);
            }
        });
        btn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent1=new Intent(Intent.ACTION_PICK);
                intent1.setType("image/*");
                startActivityForResult(intent1, 1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==1 && resultCode==RESULT_OK) {
            Intent intent =new Intent("com.android.camera.action.CROP");
            //进行裁剪
            intent.setDataAndType(Uri.fromFile(new File(path)), "image/*");
            //设置是否支持裁剪
            intent.putExtra("crop", true);
            //设置宽高
            intent.putExtra("aspactX", 1);
            intent.putExtra("aspactY", 1);
            //设置输出图片的大小
            intent.putExtra("outputX", 250);
            intent.putExtra("outputY", 250);
            //设置讲图片进行返回
            intent.putExtra("return-data",true);
            startActivityForResult(intent, 2);
        }
        if (requestCode==2 && resultCode==RESULT_OK) {
            Bitmap bitmap = data.getParcelableExtra("data");
            imageView.setImageBitmap(bitmap);
        }

    }

    //相册裁剪
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==1 && resultCode==RESULT_OK) {
            //获取路径的Uri
            Uri uri=data.getData();
            Intent intent =new Intent("com.android.camera.action.CROP");
            //进行裁剪
            intent.setDataAndType(Uri.fromFile(new File(path)), "image/*");
            //设置是否支持裁剪
            intent.putExtra("crop", true);
            //设置宽高
            intent.putExtra("aspactX", 1);
            intent.putExtra("aspactY", 1);
            //设置输出图片的大小
            intent.putExtra("outputX", 250);
            intent.putExtra("outputY", 250);
            //设置讲图片进行返回
            intent.putExtra("return-data",true);
            startActivityForResult(intent, 2);
        }
        if (requestCode==2 && resultCode==RESULT_OK) {
            Bitmap bitmap = data.getParcelableExtra("data");
            imageView.setImageBitmap(bitmap);
        }

    }*/
}

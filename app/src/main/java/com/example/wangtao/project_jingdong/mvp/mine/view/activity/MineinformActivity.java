package com.example.wangtao.project_jingdong.mvp.mine.view.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BaseActivity;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineLoginBean;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineRegBean;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineUploadBean;
import com.example.wangtao.project_jingdong.mvp.mine.presenter.MinePresenter;
import com.example.wangtao.project_jingdong.mvp.mine.view.iview.IMineView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MineinformActivity extends BaseActivity<MinePresenter> implements IMineView {

    private String path= Environment.getExternalStorageDirectory()+"/camera.png";
    private Button cancel_setting;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private SimpleDraweeView simpleDraweeView;
    private Button qXiao;
    private Button xCe;
    private Button xJi;
    private AlertDialog dialog;

    @Override
    protected int protetedId() {
        return R.layout.activity_mineinform;
    }
    @Override
    protected MinePresenter proPresenter() {
        return new MinePresenter(this);
    }

    @Override
    protected void initView() {
        preferences = getSharedPreferences("name", MODE_PRIVATE);
        editor = preferences.edit();
        cancel_setting = findViewById(R.id.mineinfor_activity_cancel_setting);
        simpleDraweeView = findViewById(R.id.mine_inform_activity_simple);
    }

    @Override
    protected void initListener() {

    }


    @Override
    protected void initData() {
        String image = preferences.getString("image", "");
        if (image !=""){
             simpleDraweeView.setImageURI(image);
        }
        if (preferences.getBoolean("ischeck",false)){
          cancel_setting.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  /* editor.putBoolean("ischeck",false);
                   editor.putString("username","");
                   editor.putString("image","");
                   editor.commit();*/
                  dialog = new AlertDialog.Builder(MineinformActivity.this)
                          .setTitle("提示:")
                          .setMessage("确定注销吗？")
                          .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                              @Override
                              public void onClick(DialogInterface dialog, int which) {

                              }
                          })
                          .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                              @Override
                              public void onClick(DialogInterface dialog, int which) {
                                    /* editor.putBoolean("ischeck",false);
                                     editor.putString("username","");
                                     editor.putString("image","");
                                     editor.commit();*/
                                    editor.clear();
                                  editor.commit();
                                  Intent intent = getIntent();
                                  setResult(3,intent);
                                  finish();
                              }
                          })
                          .create();
                  dialog.show();

              }
          });

          simpleDraweeView.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View v) {
                  View inflate = View.inflate(MineinformActivity.this, R.layout.mine_inform_camear_btn, null);
                  xJi = inflate.findViewById(R.id.mine_inform_camear_xiangji);
                  xCe = inflate.findViewById(R.id.mine_inform_camear_xiangce);
                  qXiao = inflate.findViewById(R.id.mine_inform_camear_quxiao);
                  final AlertDialog dialog = new AlertDialog.Builder(MineinformActivity.this)
                          .setView(inflate)
                          .create();
                    dialog.show();
                  xJi.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          // TODO Auto-generated method stub
                          //打开相机
                          Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                          //将图片存入sdcard
                          intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(path)));
                          startActivityForResult(intent, 100);
                          dialog.dismiss();
                      }
                  });
                  xCe.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          // TODO Auto-generated method stub
                          Intent intent1=new Intent(Intent.ACTION_PICK);
                          intent1.setType("image/*");
                          startActivityForResult(intent1, 300);
                          dialog.dismiss();
                      }
                  });
                  qXiao.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          dialog.dismiss();
                      }
                  });
              }
          });
        }else{
             Toast.makeText(MineinformActivity.this,"请先登录",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void getMineSuccess(MineLoginBean json) {

    }

    @Override
    public void getMineError(String error) {

    }

    @Override
    public void RegMineSuccess(MineRegBean json) {

    }

    @Override
    public void getUploadMineSuccess(MineUploadBean json) {
        String code = json.getCode();
        if (code.equalsIgnoreCase("0")){
            Toast.makeText(MineinformActivity.this,"上传成功",Toast.LENGTH_SHORT).show();
           /* Intent intent = getIntent();
            setResult(3,intent);
            finish();*/
           Intent intent=new Intent(MineinformActivity.this,MineLoginActivity.class);
           intent.putExtra("Values",1);
           startActivity(intent);
            finish();
        }else{
            Toast.makeText(MineinformActivity.this,"上传失败",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void RegMineError(String error) {

    }

    @Override
    public void onFaild(String onfaild) {

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==100 && resultCode==RESULT_OK) {
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
            startActivityForResult(intent, 200);
        }
        if (requestCode==200 && resultCode==RESULT_OK) {
            Bitmap bitmap = data.getParcelableExtra("data");
            simpleDraweeView.setImageBitmap(bitmap);
            File resourceFile = getResourceFile(bitmap);
            RequestBody body = RequestBody.create(MediaType.parse("image/*"),resourceFile);
            MultipartBody.Part part = MultipartBody.Part.createFormData("file", resourceFile.getName(), body);
            SharedPreferences name = getSharedPreferences("name", MODE_PRIVATE);
            String uid = name.getString("uid", "");
            if (!uid.isEmpty()&& !uid.equals("")){
                    presenter.getUploadMineRegPresenter(uid,part);
            }
           /* editor.putString("image",part+"");
            editor.commit();*/
        }
        if (requestCode ==300 && resultCode==RESULT_OK) {
            Intent intent =new Intent("com.android.camera.action.CROP");
            //进行裁剪
            /*intent.setDataAndType(Uri.fromFile(new File(path)), "image/*");*/
            Uri data1 = data.getData();
            //设置是否支持裁剪
            intent.putExtra("crop", true);
            //设置宽高
            intent.setDataAndType(data1,"image/*");

            intent.putExtra("aspactX", 1);
            intent.putExtra("aspactY", 1);
            //设置输出图片的大小
            intent.putExtra("outputX", 250);
            intent.putExtra("outputY", 250);
            //设置讲图片进行返回
            intent.putExtra("return-data",true);
            startActivityForResult(intent, 200);
        }


    }

    //相册裁剪
    public File getResourceFile(Bitmap bitmap){
        File file =new File(MineinformActivity.this.getFilesDir().getAbsolutePath());
        if (!file.exists()){
             //如果file不存在 则创建此文件
            file.mkdirs();
        }
        //给据获取的file文件夹 生成带根目录的图片文件
        File file1=new File(file,"image.png");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file1);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
            //刷新流
            fileOutputStream.flush();
            //关流
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file1;
    }

}

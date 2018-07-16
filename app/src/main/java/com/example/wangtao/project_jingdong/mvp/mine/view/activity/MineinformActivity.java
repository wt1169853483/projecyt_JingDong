package com.example.wangtao.project_jingdong.mvp.mine.view.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BaseActivity;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineLoginBean;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineRegBean;
import com.example.wangtao.project_jingdong.mvp.mine.presenter.MinePresenter;
import com.example.wangtao.project_jingdong.mvp.mine.view.iview.IMineView;

public class MineinformActivity extends BaseActivity<MinePresenter> implements IMineView {


    private Button cancel_setting;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

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
    }

    @Override
    protected void initListener() {

    }


    @Override
    protected void initData() {
          cancel_setting.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  AlertDialog dialog = new AlertDialog.Builder(MineinformActivity.this)
                          .setTitle("提示:")
                          .setMessage("确定注销")
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
    public void RegMineError(String error) {

    }

    @Override
    public void onFaild(String onfaild) {

    }
}

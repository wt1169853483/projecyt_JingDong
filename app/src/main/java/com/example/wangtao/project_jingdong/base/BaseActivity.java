package com.example.wangtao.project_jingdong.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.BaseAdapter;

/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity{
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(protetedId());
        initView();
        initListener();
        presenter =proPresenter();
        initData();
    }

    protected abstract int protetedId();
    protected abstract void initView();
    protected abstract void initListener();
    protected abstract P proPresenter();
    protected abstract void initData();

    //处理内存泄漏

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}

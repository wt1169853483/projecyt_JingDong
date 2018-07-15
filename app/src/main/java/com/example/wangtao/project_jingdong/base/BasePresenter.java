package com.example.wangtao.project_jingdong.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public abstract class BasePresenter <V extends Iview>{
    protected  V iview;
    protected CompositeDisposable compositeDisposable=new CompositeDisposable();
    public BasePresenter(V iview) {
        this.iview = iview;
        onModel();
    }

    protected abstract void onModel();

    void onDestroy(){

        compositeDisposable.clear();
    }
}

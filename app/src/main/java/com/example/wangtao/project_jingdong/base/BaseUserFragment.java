package com.example.wangtao.project_jingdong.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public abstract class BaseUserFragment<P extends BasePresenter> extends Fragment {
    protected P presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(protetedId(),container,false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (presenter == null){
            presenter =proPresenter();
        }
        initListener();
        initData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
               if (presenter == null){
                       return;
               }
               initData();
        }
    }

    protected abstract int protetedId();
    protected abstract void initView(View view);
    protected abstract void initListener();
    protected abstract P proPresenter();
    protected abstract void initData();

    //处理内存泄漏
    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}

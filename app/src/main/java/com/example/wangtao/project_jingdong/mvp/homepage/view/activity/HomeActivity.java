package com.example.wangtao.project_jingdong.mvp.homepage.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BaseActivity;
import com.example.wangtao.project_jingdong.mvp.homepage.model.adapter.HomeActivityRecycleAdp;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeCatagoryBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomePidBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeUtilBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeaddCarBean;
import com.example.wangtao.project_jingdong.mvp.homepage.presenter.HomePresenter;
import com.example.wangtao.project_jingdong.mvp.homepage.view.iview.HomeIview;

import java.util.List;

public class HomeActivity extends BaseActivity<HomePresenter> implements HomeIview{
    private static final String TAG = "HomeActivity";
    private RecyclerView recyclerView;
    private int position;

    @Override
    protected int protetedId() {
        return R.layout.activity_home;
    }
    @Override
    protected HomePresenter proPresenter() {
        return new HomePresenter(this);
    }
    @Override
    protected void initView() {
          //获取组件
        recyclerView = findViewById(R.id.home_activity_recycle);
    }

    @Override
    protected void initListener() {
        Intent intent = getIntent();
       position = intent.getIntExtra("position",0);
        Log.d(TAG, "initListener: "+position);
    }

    @Override
    protected void initData() {
           presenter.getPresenterMiaosha(position+"");
    }

    @Override
    public void getHomeSuccess(HomeUtilBean json) {
    }

    @Override
    public void getHomeError(String error) {

    }

    @Override
    public void getCatagorySuccess(HomeCatagoryBean json) {

    }

    @Override
    public void getCatagoryError(String error) {

    }

    @Override
    public void getDataSuccess(HomeaddCarBean json) {
        Toast.makeText(HomeActivity.this,json.getMsg(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void getDataError(String error) {

    }

    @Override
    public void getPidDataSuccess(HomePidBean json) {

        HomePidBean.DataBean data = json.getData();
        Log.d(TAG, "getPidDataSuccess: +++++++++++++++++++"+data.toString());
        HomeActivityRecycleAdp homeActivityRecycleAdp=new HomeActivityRecycleAdp(data,HomeActivity.this,presenter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(HomeActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(homeActivityRecycleAdp);
    }

    @Override
    public void getPidDataError(String error) {

    }
}

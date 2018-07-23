package com.example.wangtao.project_jingdong.mvp.indent.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BaseActivity;
import com.example.wangtao.project_jingdong.mvp.discover.Model.adapter.DiscoverPagerAdapters;
import com.example.wangtao.project_jingdong.mvp.discover.view.fragment.FuLiFragment;
import com.example.wangtao.project_jingdong.mvp.indent.model.adapter.IndentePagerAdapters;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentAddrBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentUpdataBean;
import com.example.wangtao.project_jingdong.mvp.indent.presenter.IndentPresenter;
import com.example.wangtao.project_jingdong.mvp.indent.view.fragment.AllFragment;
import com.example.wangtao.project_jingdong.mvp.indent.view.fragment.CanceledFragment;
import com.example.wangtao.project_jingdong.mvp.indent.view.fragment.NotPaidFragment;
import com.example.wangtao.project_jingdong.mvp.indent.view.fragment.PaidsFragment;
import com.example.wangtao.project_jingdong.mvp.indent.view.iview.IndentView;

import java.util.ArrayList;
import java.util.List;

public class IndentActivity extends BaseActivity<IndentPresenter> implements IndentView {

    private RecyclerView recyclerView;
    private String uid;
    private TextView sumpriceText;
    int sumPrice=0;
    private ImageView imageBack;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private  List<Fragment> fragmentList =new ArrayList<>();
    @Override
    protected int protetedId() {
        return R.layout.activity_indent;
    }
    @Override
    protected IndentPresenter proPresenter() {
        return new IndentPresenter(this);
    }
    @Override
    protected void initView() {

        imageBack = findViewById(R.id.activity_indent_back);
        tabLayout = findViewById(R.id.activity_indent_tabLayout);
        viewPager = findViewById(R.id.activity_indent_viewPager);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
            // presenter.getClassPresenter(uid);
        fragmentList.clear();
        Fragment allFragment= AllFragment.create("全部");
        Fragment NotPaidledFragment= NotPaidFragment.create("待支付");
        Fragment PaidsledFragment= PaidsFragment.create("已支付");
        Fragment canceledFragment= CanceledFragment.create("已取消");
        fragmentList.add(allFragment);
        fragmentList.add(NotPaidledFragment);
        fragmentList.add(PaidsledFragment);
        fragmentList.add(canceledFragment);
        ///getChildFragmentManager()
        IndentePagerAdapters discoverPagerAdapters=new IndentePagerAdapters(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(discoverPagerAdapters);


        //设置点击下滑线 游标
        tabLayout.setSelectedTabIndicatorColor(Color.RED);
        //添加选项卡
        TabLayout.Tab tab1=tabLayout.newTab();
        tab1.setText("全部");
        tabLayout.addTab(tab1);
        TabLayout.Tab tab2=tabLayout.newTab();
        tab2.setText("待支付");
        tabLayout.addTab(tab2);
        TabLayout.Tab tab3=tabLayout.newTab();
        tab3.setText("已支付");
        tabLayout.addTab(tab3);
        TabLayout.Tab tab4=tabLayout.newTab();
        tab4.setText("已取消");
        tabLayout.addTab(tab4);
        //把tabLayout 和 viewPager关联
        tabLayout.setupWithViewPager(viewPager);
        //滑动
        // tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void getDataSuccess(IndentBean json) {
    }

    @Override
    public void getUpdataSuccess(IndentUpdataBean json) {

    }

    @Override
    public void getDufaAddrSuccess(IndentAddrBean json) {

    }

    @Override
    public void getDataError(String error) {

    }
     
}

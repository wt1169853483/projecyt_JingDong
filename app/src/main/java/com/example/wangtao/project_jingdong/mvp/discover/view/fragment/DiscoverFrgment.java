package com.example.wangtao.project_jingdong.mvp.discover.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BaseActivity;
import com.example.wangtao.project_jingdong.base.BaseFragment;
import com.example.wangtao.project_jingdong.base.BaseUserFragment;
import com.example.wangtao.project_jingdong.mvp.discover.Model.adapter.DiscoverPagerAdapters;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.FuliBean;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.ISOBean;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.NewsBean;
import com.example.wangtao.project_jingdong.mvp.discover.presenter.DiscoverPresenterl;
import com.example.wangtao.project_jingdong.mvp.discover.view.iview.IDiscoverView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangtao on 2018/7/18.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class DiscoverFrgment extends BaseUserFragment<DiscoverPresenterl> implements IDiscoverView{
    private List<Fragment> fragmentList=new ArrayList<>();
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected int protetedId() {
        return R.layout.discover_fragment;
    }

    @Override
    protected void initView(View view) {
        tabLayout = view.findViewById(R.id.discover_fragment_tabLayout);
        viewPager = view.findViewById(R.id.discover_fragment_viewpager);
    }

    @Override
    protected DiscoverPresenterl proPresenter() {
        return new DiscoverPresenterl(this);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        fragmentList.clear();
        Fragment androidFragment= AndroidFragment.create("新闻");
        Fragment IsoFragment= ISOFragment.create("天天有笑");
        Fragment FuliFragment= FuLiFragment.create("美女");
        fragmentList.add(androidFragment);
        fragmentList.add(IsoFragment);
        fragmentList.add(FuliFragment);

        DiscoverPagerAdapters discoverPagerAdapters=new DiscoverPagerAdapters(getChildFragmentManager(),fragmentList);
        viewPager.setAdapter(discoverPagerAdapters);


      //设置点击下滑线 游标
        tabLayout.setSelectedTabIndicatorColor(Color.RED);
       //添加选项卡
        TabLayout.Tab tab1=tabLayout.newTab();
        tab1.setText("新闻");
        tabLayout.addTab(tab1);
        TabLayout.Tab tab2=tabLayout.newTab();
        tab2.setText("天天有笑");
        tabLayout.addTab(tab2);
        TabLayout.Tab tab3=tabLayout.newTab();
        tab3.setText("美女");
        tabLayout.addTab(tab3);
         //把tabLayout 和 viewPager关联
        tabLayout.setupWithViewPager(viewPager);
         //滑动
        // tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    @Override
    public void getDiscoverSuccess(NewsBean json) {

    }

    @Override
    public void getFuLiDiscoverSuccess(FuliBean json) {

    }

    @Override
    public void getISODiscoverSuccess(ISOBean json) {

    }

    @Override
    public void getDiscoverError(String error) {

    }

}

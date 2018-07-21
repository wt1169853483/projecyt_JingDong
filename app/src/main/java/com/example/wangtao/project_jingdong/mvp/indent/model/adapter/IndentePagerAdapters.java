package com.example.wangtao.project_jingdong.mvp.discover.Model.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wangtao on 2018/7/18.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class DiscoverPagerAdapters extends FragmentPagerAdapter {
   private  List<Fragment> list;

    public DiscoverPagerAdapters(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

   /*@Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = list.get(position).getArguments().getString("title").toString();
        return title;
    }*/

    @Override
    public int getCount() {
        return list != null ?list.size():0;
    }
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = list.get(position).getArguments().getString("title").toString();
        return title;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
    }
}

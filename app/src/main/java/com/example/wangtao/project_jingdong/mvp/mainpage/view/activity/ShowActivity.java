package com.example.wangtao.project_jingdong.mvp.mainpage.view.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.mvp.classify.view.fragment.ClassifyFragment;
import com.example.wangtao.project_jingdong.mvp.discover.view.fragment.DiscoverFrgment;
import com.example.wangtao.project_jingdong.mvp.homepage.view.fragment.HomeFragment;
import com.example.wangtao.project_jingdong.mvp.mine.view.fragment.MineFragment;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.view.fragment.ShopingFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class ShowActivity extends AppCompatActivity {

    private BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
    }

    private void initView() {
          //获取组件
        bottomBar = findViewById(R.id.show_bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                    transaction.replace(R.id.show_frameLayout,new HomeFragment());
                    transaction.commit();
                }
                if (tabId == R.id.tab_classFy) {
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                    transaction.replace(R.id.show_frameLayout,new ClassifyFragment());
                    transaction.commit();
                }
                if (tabId == R.id.tab_discover) {
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                    transaction.replace(R.id.show_frameLayout,new DiscoverFrgment());
                    transaction.commit();
                }
                if (tabId == R.id.tab_shoping) {
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                    transaction.replace(R.id.show_frameLayout,new ShopingFragment());
                    transaction.commit();
                }
                if (tabId == R.id.tab_mein) {
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                    transaction.replace(R.id.show_frameLayout,new MineFragment());
                    transaction.commit();
                }
            }
        });

    }

    public BottomBar getBottomBar(){
       return bottomBar;
    }

    public void  InitShoping(){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.replace(R.id.show_frameLayout,new ShopingFragment());
        transaction.commit();
    }

}

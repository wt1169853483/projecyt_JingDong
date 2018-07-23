package com.example.wangtao.project_jingdong.mvp.homepage.model;


import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeButBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeCatagoryBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomePidBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeUtilBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeaddCarBean;
import com.example.wangtao.project_jingdong.utils.retrofit.MyRetrofitManager;

import io.reactivex.Observable;

/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class HomeModel {
    private static final String TAG = "HomeModel";
        public Observable<HomeUtilBean> getHomeModel(){
        MyApi myApi = MyRetrofitManager.getDefault().create(MyApi.class);
        Observable<HomeUtilBean> homeUtilBeanObservable = myApi.homeGet();
        return homeUtilBeanObservable;
        }

    public Observable<HomePidBean> getHomemiaosha(String pid){
        return MyRetrofitManager.getDefault().create(MyApi.class).homegetPid(pid);
    }
    public Observable<HomeCatagoryBean> getCataModel(){
        MyApi myApi = MyRetrofitManager.getDefault().create(MyApi.class);
        Observable<HomeCatagoryBean> homeUtilBeanObservable = myApi.cataGoryGet();
        return homeUtilBeanObservable;
    }
    public Observable<HomeaddCarBean> getaddCar(String uid,String pid){
        MyApi myApi = MyRetrofitManager.getDefault().create(MyApi.class);
        Observable<HomeaddCarBean> homeCatagoryBeanObservable = myApi.homeAddCar(uid, pid);
        return homeCatagoryBeanObservable;
    }
    public Observable<HomeButBean> getBuyCar(String uid, String price){
        MyApi myApi = MyRetrofitManager.getDefault().create(MyApi.class);
        Observable<HomeButBean> homeCatagoryBeanObservable = myApi.getBuySearch(uid,price);
        return homeCatagoryBeanObservable;
    }
}

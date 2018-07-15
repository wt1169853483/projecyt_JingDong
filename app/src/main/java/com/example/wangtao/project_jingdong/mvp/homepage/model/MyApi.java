package com.example.wangtao.project_jingdong.mvp.homepage.model;


import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeCatagoryBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomePidBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeSearchBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeUtilBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeaddCarBean;
import com.example.wangtao.project_jingdong.utils.constant.Config;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public interface MyApi {
        @GET(Config.home_luibo_url)
        Observable<HomeUtilBean> homeGet();

        @GET(Config.home_urlRecycle)
        Observable<HomeCatagoryBean> cataGoryGet();
        @GET(Config.home_pid_url)
        Observable<HomePidBean> homegetPid(@Query("pid") String pid);
        //添加购物车
        @GET(Config.addCar_url)
        Observable<HomeaddCarBean> homeAddCar(@Query("uid") String uid, @Query("pid") String pid);
        //查询购物车
        @GET(Config.getCar_url)
        Observable<HomeCatagoryBean> homegetCar(@Query("uid") String uid);
        //查询搜索框
        @GET(Config.fei_sousuo)
        Observable<HomeSearchBean> homegetSearch(@Query("keywords") String keywords,@Query("page") String page,@Query("sort") String sort);
}

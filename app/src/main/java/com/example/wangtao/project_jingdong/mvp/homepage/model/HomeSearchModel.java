package com.example.wangtao.project_jingdong.mvp.homepage.model;


import com.example.wangtao.project_jingdong.mvp.homepage.model.MyApi;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeCatagoryBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomePidBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeSearchBean;
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
public class HomeSearchModel {
    public Observable<HomeSearchBean> getHomemiaosha(String keywords,String page,String sort){
        return MyRetrofitManager.getDefault().create(MyApi.class).homegetSearch(keywords,page,sort);
    }

}

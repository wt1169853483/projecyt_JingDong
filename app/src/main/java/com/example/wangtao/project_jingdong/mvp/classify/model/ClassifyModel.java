package com.example.wangtao.project_jingdong.mvp.classify.model;

import android.util.Log;

import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyLeftBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyPscidBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyRightBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.MyApi;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeUtilBean;
import com.example.wangtao.project_jingdong.utils.retrofit.MyRetrofitManager;

import io.reactivex.Observable;

/**
 * Created by wangtao on 2018/7/12.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class ClassifyModel {
    private static final String TAG = "ClassifyModel";

    public Observable<ClassifyLeftBean> getClassifyModel(){
        ClassifyApi classifyApi = MyRetrofitManager.getDefault().create(ClassifyApi.class);
        Observable<ClassifyLeftBean> classifyLeftURl = classifyApi.getClassifyLeftURl();
        return classifyLeftURl;
    }
    public Observable<ClassifyRightBean> getClassifyRightModel(String url){
        ClassifyApi classifyApi = MyRetrofitManager.getDefault().create(ClassifyApi.class);
        Observable<ClassifyRightBean> classifyRightUrl = classifyApi.getClassifyRightUrl(url);
        return classifyRightUrl;
    }
    public Observable<ClassifyPscidBean> getPscidModel(String pscid){
       /* ClassifyApi classifyApi = MyRetrofitManager.getDefault().create(ClassifyApi.class);
        Observable<ClassifyRightBean> classifyRightUrl = classifyApi.getClassifyRightUrl(pscid);*/
        return MyRetrofitManager.getDefault().create(ClassifyApi.class).getPscidRightUrl(pscid);
    }
}

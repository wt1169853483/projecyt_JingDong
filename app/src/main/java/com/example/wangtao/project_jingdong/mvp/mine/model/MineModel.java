package com.example.wangtao.project_jingdong.mvp.mine.model;


import com.example.wangtao.project_jingdong.mvp.homepage.model.MyApi;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeCatagoryBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeUtilBean;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineApi;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineLoginBean;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineRegBean;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineUploadBean;
import com.example.wangtao.project_jingdong.utils.retrofit.MyRetrofitManager;

import java.io.File;

import io.reactivex.Observable;
import okhttp3.MultipartBody;

/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class MineModel {
    private static final String TAG = "HomeModel";
        public Observable<MineLoginBean> getMineLoginModel(String name,String pwd){
            MineApi mineApi = MyRetrofitManager.getDefault().create(MineApi.class);
            Observable<MineLoginBean> loginObs = mineApi.getLoginObs(name, pwd);
            return loginObs;
        }
    public Observable<MineLoginBean> getMineUserModel(String uid){
        MineApi mineApi = MyRetrofitManager.getDefault().create(MineApi.class);
        Observable<MineLoginBean> loginObs = mineApi.getUserObs(uid);
        return loginObs;
    }
        public Observable<MineRegBean> getMineRegModel(String name, String pwd){
        MineApi mineApi = MyRetrofitManager.getDefault().create(MineApi.class);
            Observable<MineRegBean> regObs = mineApi.getRegObs(name, pwd);
            return regObs;
    }
    public Observable<MineUploadBean> getUploadMineRegModel(String uid, MultipartBody.Part file){
        MineApi mineApi = MyRetrofitManager.getDefault().create(MineApi.class);
        Observable<MineUploadBean> regUpload = mineApi.getUploadRegObs(uid, file);
        return regUpload;
    }
}

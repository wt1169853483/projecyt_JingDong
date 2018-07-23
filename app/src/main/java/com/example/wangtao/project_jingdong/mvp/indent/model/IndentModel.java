package com.example.wangtao.project_jingdong.mvp.indent.model;

import com.example.wangtao.project_jingdong.mvp.classify.model.ClassifyApi;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyLeftBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyPscidBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyRightBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentAddrBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentUpdataBean;
import com.example.wangtao.project_jingdong.utils.retrofit.MyRetrofitManager;

import io.reactivex.Observable;

/**
 * Created by wangtao on 2018/7/12.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class IndentModel {
    private static final String TAG = "ClassifyModel";

    public Observable<IndentBean> getClassifyModel(String uid){
        IndentApi indentApi = MyRetrofitManager.getDefault().create(IndentApi.class);
        Observable<IndentBean> butRightUrl = indentApi.getButRightUrl(uid);
        return butRightUrl;
    }
    public Observable<IndentUpdataBean> getUpdataIndentModel(String uid,String status,String orderId){
        IndentApi indentApi = MyRetrofitManager.getDefault().create(IndentApi.class);
        Observable<IndentUpdataBean> updataRightUrl = indentApi.getUpdataRightUrl(uid, status, orderId);
        return updataRightUrl;
    }
    public Observable<IndentAddrBean> getDefaultAddrModel(String uid){
        IndentApi indentApi = MyRetrofitManager.getDefault().create(IndentApi.class);
        Observable<IndentAddrBean> updataRightUrl = indentApi.getDefaAddrightUrl(uid);
        return updataRightUrl;
    }
}

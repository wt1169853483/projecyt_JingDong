package com.example.wangtao.project_jingdong.mvp.indent.model;

import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyLeftBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyPscidBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyRightBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentAddrBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentUpdataBean;
import com.example.wangtao.project_jingdong.utils.constant.Config;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wangtao on 2018/7/12.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public interface IndentApi {
        @GET(Config.getOrders_Info)
        Observable<IndentBean> getButRightUrl(@Query("uid") String uid);
        //修改订单
        //uid=15314&status=1&orderId=10966
        @GET(Config.getUpdataOrders_Info)
        Observable<IndentUpdataBean> getUpdataRightUrl(@Query("uid") String uid, @Query("status") String status, @Query("orderId") String orderId);

        @GET(Config.getDefaultUser_addrs)
        Observable<IndentAddrBean> getDefaAddrightUrl(@Query("uid") String uid);
}

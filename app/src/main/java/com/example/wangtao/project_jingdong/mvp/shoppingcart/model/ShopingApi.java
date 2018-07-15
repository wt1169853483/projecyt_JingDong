package com.example.wangtao.project_jingdong.mvp.shoppingcart.model;

import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingBean;
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
public interface ShopingApi {
      @GET(Config.shoping_Url)
      Observable<ShopingBean> getShopingObs(@Query("uid") String uid);
}

package com.example.wangtao.project_jingdong.mvp.shoppingcart.model;

import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingButBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingDeleteBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingUpdataBean;
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
      //uid=71&sellerid=1&pid=1&selected=0&num=10
      @GET(Config.shoping_updata_Url)
      Observable<ShopingUpdataBean> getShopingUpdataObs(@Query("uid") String uid, @Query("sellerid") String sellerid, @Query("pid") String pid, @Query("selected") String selected, @Query("num") String num);
      @GET(Config.shoping_delete_Url)
      Observable<ShopingDeleteBean> getDeleteShopingObs(@Query("uid") String uid,@Query("pid") String pid);
    //  https://www.zhaoapi.cn/product/createOrder?uid=71&price=99.99
      @GET(Config.getBut_Info)
      Observable<ShopingButBean> getButShopingObs(@Query("uid") String uid, @Query("price") String price);
}

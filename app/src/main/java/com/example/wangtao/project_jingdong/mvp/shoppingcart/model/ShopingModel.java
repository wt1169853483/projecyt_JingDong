package com.example.wangtao.project_jingdong.mvp.shoppingcart.model;

import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingButBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingDeleteBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingUpdataBean;
import com.example.wangtao.project_jingdong.utils.retrofit.MyRetrofitManager;
import io.reactivex.Observable;

/**
 * Created by wangtao on 2018/7/12.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class ShopingModel {
    private static final String TAG = "ClassifyModel";
    public Observable<ShopingBean> getShopingModel(String uid){
        ShopingApi shopingApi = MyRetrofitManager.getDefault().create(ShopingApi.class);
        Observable<ShopingBean> shopingObs = shopingApi.getShopingObs(uid);
        return shopingObs;
    }
    public Observable<ShopingUpdataBean> getUpdataShopingModel(String uid, String sell, String pid, String selected, String num){
        ShopingApi shopingApi = MyRetrofitManager.getDefault().create(ShopingApi.class);
        Observable<ShopingUpdataBean> shopingObs = shopingApi.getShopingUpdataObs(uid,sell,pid,selected,num);
        return shopingObs;
    }
    public Observable<ShopingDeleteBean> getDeleteShopingModel(String uid,String pid){
        ShopingApi shopingApi = MyRetrofitManager.getDefault().create(ShopingApi.class);
        Observable<ShopingDeleteBean> shopingObs = shopingApi.getDeleteShopingObs(uid,pid);
        return shopingObs;
    }
    public Observable<ShopingButBean> getButShopingModel(String uid, String price){
        ShopingApi shopingApi = MyRetrofitManager.getDefault().create(ShopingApi.class);
        Observable<ShopingButBean> shopingObs = shopingApi.getButShopingObs(uid,price);
        return shopingObs;
    }
}

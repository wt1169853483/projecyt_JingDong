package com.example.wangtao.project_jingdong.mvp.shoppingcart.model;

import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingBean;
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
}

package com.example.wangtao.project_jingdong.mvp.shoppingcart.view.iview;

import com.example.wangtao.project_jingdong.base.Iview;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyLeftBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyRightBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingButBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingDeleteBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingUpdataBean;

/**
 * Created by wangtao on 2018/7/12.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public interface IShopingView extends Iview {
      void getClassSuccess(ShopingBean json);
      void getUpdataClassSuccess(ShopingUpdataBean json);
      void getDeleteClassSuccess(ShopingDeleteBean json);
      void getButClassSuccess(ShopingButBean json);
      void getClassError(String error);
}

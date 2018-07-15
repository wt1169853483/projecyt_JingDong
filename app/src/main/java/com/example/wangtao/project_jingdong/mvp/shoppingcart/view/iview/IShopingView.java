package com.example.wangtao.project_jingdong.mvp.shoppingcart.view.iview;

import com.example.wangtao.project_jingdong.base.Iview;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyLeftBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyRightBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingBean;

/**
 * Created by wangtao on 2018/7/12.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public interface IShopingView extends Iview {
      void getClassSuccess(ShopingBean json);
      void getClassError(String error);
}

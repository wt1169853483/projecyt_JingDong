package com.example.wangtao.project_jingdong.mvp.homepage.view.iview;

import com.example.wangtao.project_jingdong.base.Iview;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeCatagoryBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomePidBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeUtilBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeaddCarBean;

/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public interface HomeIview extends Iview {
       void getHomeSuccess(HomeUtilBean json);
       void getHomeError(String error);

       void getCatagorySuccess(HomeCatagoryBean json);
       void getCatagoryError(String error);

       void getDataSuccess(HomeaddCarBean json);
       void getDataError(String error);

       void getPidDataSuccess(HomePidBean json);
       void getPidDataError(String error);
}

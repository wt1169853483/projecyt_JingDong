package com.example.wangtao.project_jingdong.mvp.homepage.view.iview;

import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeUtilBean;

/**
 * Created by wangtao on 2018/7/13.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public interface IHomeActivity {
     void getDataSuccess(HomeUtilBean json);
     void getDataError(String error);
}

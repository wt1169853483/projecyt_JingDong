package com.example.wangtao.project_jingdong.mvp.discover.view.iview;

import com.example.wangtao.project_jingdong.base.Iview;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.FuliBean;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.ISOBean;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.NewsBean;

/**
 * Created by wangtao on 2018/7/18.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public interface IDiscoverView extends Iview {
     void getDiscoverSuccess(NewsBean json);
     void getFuLiDiscoverSuccess(FuliBean json);
     void getISODiscoverSuccess(ISOBean json);
     void getDiscoverError(String error);
}

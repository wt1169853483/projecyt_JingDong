package com.example.wangtao.project_jingdong.mvp.discover.Model;

import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.FuliBean;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.ISOBean;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.NewsBean;
import com.example.wangtao.project_jingdong.mvp.discover.view.iview.DiscoverMap;
import com.example.wangtao.project_jingdong.utils.retrofit.MyRetrofitManager;

import io.reactivex.Observable;

/**
 * Created by wangtao on 2018/7/18.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class DiscoverModel {
          public Observable<NewsBean> getDiscModel(int page){
                  return MyRetrofitManager.getDefault().create(DiscoverMap.class).getNews(page);
          }

    public Observable<FuliBean> getFuLiDiscModel(int page){
        return MyRetrofitManager.getDefault().create(DiscoverMap.class).getFuLi(page);
    }
    public Observable<ISOBean> getISODiscModel(int page){
        return MyRetrofitManager.getDefault().create(DiscoverMap.class).getISO(page);
    }
}

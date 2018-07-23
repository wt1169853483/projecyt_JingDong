package com.example.wangtao.project_jingdong.mvp.discover.view.iview;

import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.FuliBean;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.ISOBean;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.NewsBean;
import com.example.wangtao.project_jingdong.utils.constant.Config;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wangtao on 2018/7/18.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 *///106e461cd267b52955afda07e9315eb0
public interface DiscoverMap {
          @GET("http://v.juhe.cn/"+Config.getXinWei_Info+"?type=top&key=83a69c67e9272f816e42450ef0eb50ee")
          Observable<NewsBean> getNews(@Query("page") int page);
       //http://api.tianapi.com/meinv/?key=APIKEY&num=10
         @GET("http://api.tianapi.com/meinv/?key=d341c14e4825a09886b37f583156adb1&num=10")
         Observable<FuliBean> getFuLi(@Query("page") int page);

         @GET("http://api.tianapi.com/txapi/joke/?key=d341c14e4825a09886b37f583156adb1&num=10")
         Observable<ISOBean> getISO(@Query("page") int page);
}

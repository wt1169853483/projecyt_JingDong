package com.example.wangtao.project_jingdong.mvp.classify.model;

import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyLeftBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyPscidBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyRightBean;
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
public interface ClassifyApi {
        @GET(Config.classify_LeftURl)
        Observable<ClassifyLeftBean> getClassifyLeftURl();

        @GET(Config.classify_RightURl)
        Observable<ClassifyRightBean> getClassifyRightUrl(@Query("cid") String cid);
        @GET(Config.fei_pscid)
        Observable<ClassifyPscidBean> getPscidRightUrl(@Query("pscid") String pscid);
}

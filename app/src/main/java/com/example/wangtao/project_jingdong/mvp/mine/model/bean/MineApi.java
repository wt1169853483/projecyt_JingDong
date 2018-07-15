package com.example.wangtao.project_jingdong.mvp.mine.model.bean;

import com.example.wangtao.project_jingdong.utils.constant.Config;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wangtao on 2018/7/13.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public interface MineApi {
     @GET(Config.minelogine_Url)
    Observable<MineLoginBean> getLoginObs(@Query("mobile") String name,@Query("password") String password);

    @GET(Config.minereg_Url)
    Observable<MineRegBean> getRegObs(@Query("mobile") String name,@Query("password") String password);
}

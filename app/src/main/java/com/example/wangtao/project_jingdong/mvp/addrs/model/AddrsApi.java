package com.example.wangtao.project_jingdong.mvp.addrs.model;

import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsAddBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsDefaultBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsSetBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsUpdataBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsUserBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentAddrBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentUpdataBean;
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
public interface AddrsApi {
        @GET(Config.getDefaultUser_addrs)
        Observable<AddrsDefaultBean> getDefaAddrightUrl(@Query("uid") String uid);
        //获取常用地址
        @GET(Config.getUser_addrs)
        Observable<AddrsUserBean> getUserRightUrl(@Query("uid") String uid);
        //https://www.zhaoapi.cn/user/addAddr?uid=71&addr=北京市昌平区金域国际1-1-1&mobile=18612991023&name=kson
        @GET(Config.getaddUser_addrs)
        Observable<AddrsAddBean> getAddRightUrl(@Query("uid") String uid, @Query("addr") String addr,@Query("mobile") String mobile,@Query("name") String name);

        @GET(Config.getUpdataUser_addrs)
        Observable<AddrsUpdataBean> getUpdataRightUrl(@Query("uid") String uid, @Query("addrid") String addrid,@Query("mobile") String mobile, @Query("name") String name, @Query("addr") String addr);

        @GET(Config.getDefault_steing_addrs)
        Observable<AddrsSetBean> getSetDefaAddrightUrl(@Query("uid") String uid, @Query("addrid") String addrid, @Query("status") String status);
}

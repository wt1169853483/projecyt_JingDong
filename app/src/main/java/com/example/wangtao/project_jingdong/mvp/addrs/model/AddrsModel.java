package com.example.wangtao.project_jingdong.mvp.addrs.model;

import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsAddBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsDefaultBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsSetBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsUpdataBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsUserBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.IndentApi;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentAddrBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentUpdataBean;
import com.example.wangtao.project_jingdong.utils.retrofit.MyRetrofitManager;

import io.reactivex.Observable;

/**
 * Created by wangtao on 2018/7/12.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class AddrsModel {
    public Observable<AddrsDefaultBean> getDefaultAddrModel(String uid){
        AddrsApi addrsApi = MyRetrofitManager.getDefault().create(AddrsApi.class);
        Observable<AddrsDefaultBean> defaAddrightUrl = addrsApi.getDefaAddrightUrl(uid);
        return defaAddrightUrl;
    }
    public Observable<AddrsUserBean> getUserAddrModel(String uid){
        AddrsApi addrsApi = MyRetrofitManager.getDefault().create(AddrsApi.class);
        Observable<AddrsUserBean> defaAddrightUrl = addrsApi.getUserRightUrl(uid);
        return defaAddrightUrl;
    }
    public Observable<AddrsAddBean> getAddAddrModel(String uid,String addr,String mobile,String name){
        AddrsApi addrsApi = MyRetrofitManager.getDefault().create(AddrsApi.class);
        Observable<AddrsAddBean> defaAddrightUrl = addrsApi.getAddRightUrl(uid,addr,mobile,name);
        return defaAddrightUrl;
    }

    public Observable<AddrsUpdataBean> getUpdataAddrModel(String uid, String addrid,String mobile, String name, String addr){
        AddrsApi addrsApi = MyRetrofitManager.getDefault().create(AddrsApi.class);
        Observable<AddrsUpdataBean> defaAddrightUrl = addrsApi.getUpdataRightUrl(uid,addrid,mobile,name,addr);
        return defaAddrightUrl;
    }
    public Observable<AddrsSetBean> getSetAddrModel(String uid, String addrid, String status){
        AddrsApi addrsApi = MyRetrofitManager.getDefault().create(AddrsApi.class);
        Observable<AddrsSetBean> defaAddrightUrl = addrsApi.getSetDefaAddrightUrl(uid,addrid,status);
        return defaAddrightUrl;
    }
}

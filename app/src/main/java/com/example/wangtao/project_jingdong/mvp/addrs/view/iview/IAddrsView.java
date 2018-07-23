package com.example.wangtao.project_jingdong.mvp.addrs.view.iview;

import com.example.wangtao.project_jingdong.base.Iview;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsAddBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsDefaultBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsSetBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsUpdataBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsUserBean;

/**
 * Created by wangtao on 2018/7/20.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public interface IAddrsView extends Iview {
    void getDataSuccess(AddrsDefaultBean json);
    void getUserSuccess(AddrsUserBean json);
    void getAddSuccess(AddrsAddBean json);
    void getUpdataSuccess(AddrsUpdataBean json);
    void getSetSuccess(AddrsSetBean json);
    void getDataError(String error);
}

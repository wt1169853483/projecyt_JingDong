package com.example.wangtao.project_jingdong.mvp.addrs.view;

import com.example.wangtao.project_jingdong.base.Iview;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsDefaultBean;

/**
 * Created by wangtao on 2018/7/20.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public interface IAddrsView extends Iview {
    void getDataSuccess(AddrsDefaultBean json);
    void getDataError(String error);
}

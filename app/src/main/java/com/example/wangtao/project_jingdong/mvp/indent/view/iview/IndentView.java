package com.example.wangtao.project_jingdong.mvp.indent.view.iview;

import com.example.wangtao.project_jingdong.base.Iview;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentAddrBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentUpdataBean;

/**
 * Created by wangtao on 2018/7/19.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public interface IndentView extends Iview {
      void getDataSuccess(IndentBean json);
      void getUpdataSuccess(IndentUpdataBean json);
      void getDufaAddrSuccess(IndentAddrBean json);
      void getDataError(String error);
}

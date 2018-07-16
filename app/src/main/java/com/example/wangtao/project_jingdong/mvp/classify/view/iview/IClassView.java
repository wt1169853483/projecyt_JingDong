package com.example.wangtao.project_jingdong.mvp.classify.view.iview;

import com.example.wangtao.project_jingdong.base.Iview;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyLeftBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyPscidBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyRightBean;

/**
 * Created by wangtao on 2018/7/12.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public interface IClassView extends Iview {
      void getClassSuccess(ClassifyLeftBean json);
      void getClassError(String error);
      void getClassRightSuccess(ClassifyRightBean json);
      void getClassRightError(String error);
      void getPscidRightSuccess(ClassifyPscidBean json);
}

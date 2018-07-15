package com.example.wangtao.project_jingdong.mvp.mine.view.iview;

import com.example.wangtao.project_jingdong.base.Iview;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineLoginBean;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineRegBean;

/**
 * Created by wangtao on 2018/7/13.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public interface IMineView extends Iview {
        void getMineSuccess(MineLoginBean json);
        void getMineError(String error);
        void RegMineSuccess(MineRegBean json);
        void RegMineError(String error);
        void onFaild(String onfaild);
}

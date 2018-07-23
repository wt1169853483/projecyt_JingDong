package com.example.wangtao.project_jingdong.mvp.mine.view.fragment;

import android.view.View;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BaseFragment;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineLoginBean;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineRegBean;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineUploadBean;
import com.example.wangtao.project_jingdong.mvp.mine.presenter.MinePresenter;
import com.example.wangtao.project_jingdong.mvp.mine.view.iview.IMineView;

/**
 * Created by wangtao on 2018/7/13.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class MineLoginFragment  extends BaseFragment<MinePresenter> implements IMineView{

    @Override
    protected int protetedId() {
        return 0;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected MinePresenter proPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void getMineSuccess(MineLoginBean json) {

    }

    @Override
    public void getMineError(String error) {

    }

    @Override
    public void RegMineSuccess(MineRegBean json) {

    }

    @Override
    public void getUploadMineSuccess(MineUploadBean json) {

    }

    @Override
    public void RegMineError(String error) {

    }

    @Override
    public void onFaild(String onfaild) {

    }
}

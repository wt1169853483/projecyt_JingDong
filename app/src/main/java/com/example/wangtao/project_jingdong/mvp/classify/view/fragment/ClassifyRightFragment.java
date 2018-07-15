package com.example.wangtao.project_jingdong.mvp.classify.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BaseFragment;
import com.example.wangtao.project_jingdong.mvp.classify.model.adapter.ClassRecycleChildAdapter;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyLeftBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyRightBean;
import com.example.wangtao.project_jingdong.mvp.classify.presenter.ClassifyPresenter;
import com.example.wangtao.project_jingdong.mvp.classify.view.iview.IClassView;

import java.util.List;

/**
 * Created by wangtao on 2018/7/12.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class ClassifyRightFragment extends BaseFragment<ClassifyPresenter> implements IClassView{
    private static final String TAG = "ClassifyRightFragment";
    private RecyclerView recyclerView;

    @Override
    protected int protetedId() {
        return R.layout.classify_frgment_right;
    }
    @Override
    protected ClassifyPresenter proPresenter() {
        return new ClassifyPresenter(this);
    }
    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.classfiy_fragment_right_recycle);
    }

    @Override
    protected void initListener() {
        Bundle arguments = getArguments();
        String cid = arguments.getString("urls");
        presenter.getClassRightPresenter(cid);
    }
    @Override
    protected void initData() {

    }

    @Override
    public void getClassSuccess(ClassifyLeftBean json) {

    }

    @Override
    public void getClassError(String error) {

    }

    //右边数据请求成功
    @Override
    public void getClassRightSuccess(ClassifyRightBean json) {
        List<ClassifyRightBean.DataBean> data = json.getData();
        ClassRecycleChildAdapter classRecycleChildAdapter=new ClassRecycleChildAdapter(data,getContext());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(classRecycleChildAdapter);

    }

    @Override
    public void getClassRightError(String error) {

    }
}

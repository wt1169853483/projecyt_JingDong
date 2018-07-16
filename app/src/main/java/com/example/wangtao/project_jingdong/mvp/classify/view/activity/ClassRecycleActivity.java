package com.example.wangtao.project_jingdong.mvp.classify.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BaseActivity;
import com.example.wangtao.project_jingdong.mvp.classify.model.adapter.ClassPscidRecycleAdapter;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyLeftBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyPscidBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyRightBean;
import com.example.wangtao.project_jingdong.mvp.classify.presenter.ClassifyPresenter;
import com.example.wangtao.project_jingdong.mvp.classify.view.iview.IClassView;
import com.example.wangtao.project_jingdong.mvp.homepage.model.adapter.RectcleMiaoshaAdapter;
import com.example.wangtao.project_jingdong.mvp.homepage.view.activity.HomeActivity;

import java.util.List;

public class ClassRecycleActivity extends BaseActivity<ClassifyPresenter> implements IClassView {

    private RecyclerView recyclerView;
    private int position;

    @Override
    protected int protetedId() {
        return R.layout.activity_class_recycle;
    }

    @Override
    protected ClassifyPresenter proPresenter() {
        return new ClassifyPresenter(this);
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.activity_class_recycle_item);
    }
    @Override
    protected void initListener() {
        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);

    }


    @Override
    protected void initData() {
          presenter.getPscidRightPresenter(position+"");
    }

    @Override
    public void getClassSuccess(ClassifyLeftBean json) {

    }

    @Override
    public void getClassError(String error) {

    }

    @Override
    public void getClassRightSuccess(ClassifyRightBean json) {

    }

    @Override
    public void getClassRightError(String error) {

    }

    @Override
    public void getPscidRightSuccess(ClassifyPscidBean json) {
        final List<ClassifyPscidBean.DataBean> data = json.getData();
        ClassPscidRecycleAdapter classPscidRecycleAdapter=new ClassPscidRecycleAdapter(data);
        recyclerView.setAdapter(classPscidRecycleAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(ClassRecycleActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        classPscidRecycleAdapter.setOnClickListener(new RectcleMiaoshaAdapter.OnClickListener() {
            @Override
            public void Onclick(int position) {
                ClassifyPscidBean.DataBean dataBean = data.get(position);
                int pid = dataBean.getPid();
                Intent intent=new Intent(ClassRecycleActivity.this, HomeActivity.class);
                intent.putExtra("position",pid);
                startActivity(intent);
            }
        });
    }
}

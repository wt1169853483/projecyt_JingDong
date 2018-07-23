package com.example.wangtao.project_jingdong.mvp.discover.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BaseFragment;
import com.example.wangtao.project_jingdong.base.BaseUserFragment;
import com.example.wangtao.project_jingdong.mvp.discover.Model.adapter.DiscoveISOAdapter;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.FuliBean;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.ISOBean;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.NewsBean;
import com.example.wangtao.project_jingdong.mvp.discover.presenter.DiscoverPresenterl;
import com.example.wangtao.project_jingdong.mvp.discover.view.iview.IDiscoverView;
import com.scwang.smartrefresh.header.WaterDropHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangtao on 2018/7/18.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class ISOFragment extends BaseUserFragment<DiscoverPresenterl> implements IDiscoverView {

    private RecyclerView recyclerView;
    private int page=1;
    private  List<ISOBean.NewslistBean> list =new ArrayList<>();
    private SmartRefreshLayout smartRefreshLayout;

    public static Fragment create(String title) {
        Bundle bundle=new Bundle();
        bundle.putString("title",title);
        Fragment fragment=new ISOFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int protetedId() {
        return R.layout.discover_fragment_iso;
    }

    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.discover_fragment_iso_recycle);
        smartRefreshLayout = view.findViewById(R.id.discover_fragment_iso_smartre);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected DiscoverPresenterl proPresenter() {
        return new DiscoverPresenterl(this);
    }

    @Override
    protected void initData() {
        presenter.getISODiscover(page);
    }

    @Override
    public void getDiscoverSuccess(NewsBean json) {

    }

    @Override
    public void getFuLiDiscoverSuccess(FuliBean json) {

    }

    @Override
    public void getISODiscoverSuccess(ISOBean json) {
        final List<ISOBean.NewslistBean> newslist = json.getNewslist();
        list =newslist;
        DiscoveISOAdapter discoveISOAdapter=new DiscoveISOAdapter(list,getContext());
        recyclerView.setAdapter(discoveISOAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page =1;
                list.clear();
                initData();
                refreshLayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败

            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                page +=1;
                initData();
                list.addAll(newslist);
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败

            }
        });
        smartRefreshLayout.setRefreshHeader(new WaterDropHeader(getContext()));
//设置 Footer 为 球脉冲 样式
        smartRefreshLayout.setRefreshFooter(new BallPulseFooter(getContext()).setSpinnerStyle(SpinnerStyle.Scale));
    }

    @Override
    public void getDiscoverError(String error) {

    }
    /*@Override
    public void onStart() {
        super.onStart();
        *//*smartRefreshLayout.setEnableAutoLoadMore(true);*//*
        Log.e("tag", "setUserVisibleHint: "+"11111111111111111111111" );
        initData();

    }*/
}

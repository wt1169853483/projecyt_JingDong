package com.example.wangtao.project_jingdong.mvp.indent.view.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BaseUserFragment;
import com.example.wangtao.project_jingdong.mvp.addrs.view.activity.AddrsAcrtivity;
import com.example.wangtao.project_jingdong.mvp.discover.Model.adapter.DiscoverAndroidAdapter;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.FuliBean;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.ISOBean;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.NewsBean;
import com.example.wangtao.project_jingdong.mvp.discover.presenter.DiscoverPresenterl;
import com.example.wangtao.project_jingdong.mvp.discover.view.fragment.AndroidFragment;
import com.example.wangtao.project_jingdong.mvp.discover.view.iview.IDiscoverView;
import com.example.wangtao.project_jingdong.mvp.homepage.model.adapter.RectcleMiaoshaAdapter;
import com.example.wangtao.project_jingdong.mvp.indent.model.adapter.DiscoveIndentAdapter;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentAddrBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentUpdataBean;
import com.example.wangtao.project_jingdong.mvp.indent.presenter.IndentPresenter;
import com.example.wangtao.project_jingdong.mvp.indent.view.activity.IndentActivity;
import com.example.wangtao.project_jingdong.mvp.indent.view.iview.IndentView;
import com.scwang.smartrefresh.header.WaterDropHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by wangtao on 2018/7/18.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class AllFragment extends BaseUserFragment<IndentPresenter> implements IndentView{
    private String uid;
    private RecyclerView recyclerView;
    private TextView sumpriceText;
    private TextView infpText;
    private TextView siteText;
    private  int sumPrice=0;
    private ImageView imageView;

    @Override
    protected int protetedId() {
        return R.layout.indent_fragment_but_all;
    }

    @Override
    protected void initView(View view) {
        SharedPreferences sharedPreferences=getContext().getSharedPreferences("name",MODE_PRIVATE);
        uid = sharedPreferences.getString("uid", 71 + "");
        recyclerView = view.findViewById(R.id.activity_indent_all_recycle);
        sumpriceText = view.findViewById(R.id.activity_indent_all_commodity_car_btn);
        infpText = view.findViewById(R.id.activity_indent_all_userInfo);
        siteText = view.findViewById(R.id.activity_indent_all_site);
        //点击右键打开地址
        imageView = view.findViewById(R.id.activity_indent_all_right_image);
    }

    @Override
    protected void initListener() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), AddrsAcrtivity.class);
                startActivityForResult(intent,8);
            }
        });
    }

    @Override
    protected IndentPresenter proPresenter() {
        return new IndentPresenter(this);
    }

    @Override
    protected void initData() {
         presenter.getClassPresenter(uid);
         presenter.getDefaultAddrPresenter(uid);
    }

    @Override
    public void getDataSuccess(IndentBean json) {
        sumPrice=0;
     final List<IndentBean.DataBean> data = json.getData();
        DiscoveIndentAdapter discoveIndentAdapter=new DiscoveIndentAdapter(data,getContext());
        recyclerView.setAdapter(discoveIndentAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        if (data !=null) {
            for (int i = 0; i < data.size(); i++) {
                sumPrice += data.get(i).getPrice();
            }
        }
       sumpriceText.setText("实付款 ： ￥"+sumPrice);
        discoveIndentAdapter.setOnClickListener(new RectcleMiaoshaAdapter.OnClickListener() {
            @Override
            public void Onclick(final int position) {
                View view =View.inflate(getContext(),R.layout.indent_fragment_but_alert_setview,null);
                Button button0=view.findViewById(R.id.indent_fragment_but_alert_serview_btn0);
                Button button1=view.findViewById(R.id.indent_fragment_but_alert_serview_btn1);
                Button button2=view.findViewById(R.id.indent_fragment_but_alert_serview_btn2);
                final AlertDialog dialog = new AlertDialog.Builder(getContext())
                        .setTitle("提示操作:")
                        .setView(view)
                        .create();
                dialog.show();
                button0.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                           presenter.getClassPresenter(uid,0+"",data.get(position).getOrderid()+"");
                       dialog.dismiss();
                    }
                });
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.getClassPresenter(uid,1+"",data.get(position).getOrderid()+"");
                        dialog.dismiss();
                    }
                });
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.getClassPresenter(uid,2+"",data.get(position).getOrderid()+"");
                        dialog.dismiss();
                    }
                });
            }
        });

    }

    @Override
    public void getUpdataSuccess(IndentUpdataBean json) {
            if (json.getCode().equalsIgnoreCase("0")){
                   initData();
              //  Toast.makeText(IndentActivity.this,"成功",Toast.LENGTH_LONG).show();
            }else{
                //Toast.makeText(IndentActivity.this,"失败",Toast.LENGTH_LONG).show();
            }
    }

    @Override
    public void getDufaAddrSuccess(IndentAddrBean json) {
        IndentAddrBean.DataBean data = json.getData();
        infpText.setText("名称:"+data.getName());
        siteText.setText("地址:"+data.getAddr());
    }

    @Override
    public void getDataError(String error) {

    }

    public static Fragment create(String title) {
        Bundle bundle=new Bundle();
        bundle.putString("title",title);
        Fragment fragment=new AllFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden){
              initData();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 8&& resultCode ==1){
                initData();
        }
    }
}

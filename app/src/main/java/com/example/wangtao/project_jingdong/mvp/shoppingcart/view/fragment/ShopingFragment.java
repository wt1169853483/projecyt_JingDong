package com.example.wangtao.project_jingdong.mvp.shoppingcart.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BaseFragment;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyLeftBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.adapter.ShopingExpandAdapter;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.presenter.ShopingPresenter;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.view.iview.IShopingView;

import java.util.List;

/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class ShopingFragment extends BaseFragment<ShopingPresenter> implements IShopingView{

    private ExpandableListView expandableListView;
    private ShopingExpandAdapter shopingExpandAdapter;
    private CheckBox checkBox;
    private TextView textView;
    private Button button;

    @Override
    protected int protetedId() {
        return R.layout.shoping_fragment;
    }
    @Override
    protected ShopingPresenter proPresenter() {
        return new ShopingPresenter(this);
    }
    @Override
    protected void initView(View view) {
          //获取组件
        expandableListView = view.findViewById(R.id.shoping_fragment_expandableListView);
        checkBox = view.findViewById(R.id.shoping_fragment_chieckboxAll);
        textView = view.findViewById(R.id.shoping_fragment_priceAll);
        button = view.findViewById(R.id.shoping_fragment_numBer);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置 底部全选按钮
                //   时候所有得商品都被选中
                Boolean  booles= shopingExpandAdapter.isAllProductsSelected();
                shopingExpandAdapter.changeAllProductsStatus(!booles);
                shopingExpandAdapter.notifyDataSetChanged();
                refreshSelectedAndTotalPriceAndTotalNumber();
            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
          presenter.getShopingPresenter("16443");
    }

   //请求成功
    @Override
    public void getClassSuccess(ShopingBean json) {
        List<ShopingBean.DataBean> data = json.getData();
        shopingExpandAdapter = new ShopingExpandAdapter(data,getContext());
        expandableListView.setAdapter(shopingExpandAdapter);
        refreshSelectedAndTotalPriceAndTotalNumber();
        shopingExpandAdapter.setOnShopingListener(new ShopingExpandAdapter.OnShopingListener() {
            @Override
            public void getListGroupParamChanged(int groupPoition) {
                     Boolean boole= shopingExpandAdapter.isOnParamGourpSelledSelected(groupPoition);
                     shopingExpandAdapter.changedGourpSelledSelected(groupPoition,!boole);
                     refreshSelectedAndTotalPriceAndTotalNumber();
                     shopingExpandAdapter.notifyDataSetChanged();
            }

            @Override
            public void getListchildParamChanged(int groupPoition, int childPoition) {
                shopingExpandAdapter.changedChildSelected(groupPoition,childPoition);
                refreshSelectedAndTotalPriceAndTotalNumber();
                shopingExpandAdapter.notifyDataSetChanged();
            }

            @Override
            public void getListchildNumberChanged(int groupPoition, int childPoition, int number) {
                 shopingExpandAdapter.changedChildSelectedNumber(groupPoition, childPoition, number);
                refreshSelectedAndTotalPriceAndTotalNumber();
                shopingExpandAdapter.notifyDataSetChanged();
            }
        });
        //展开二级列表
        for (int i = 0; i < data.size(); i++) {
            expandableListView.expandGroup(i);
        }
        expandableListView.setGroupIndicator(null);
    }


    @Override
    public void getClassError(String error) {

    }

    //计算总价
    public void refreshSelectedAndTotalPriceAndTotalNumber(){
        //设置全选全不选
        Boolean boole= shopingExpandAdapter.isAllProductsSelected();
        checkBox.setChecked(boole);
         //设置总价
        int priceAll = shopingExpandAdapter.changedAllPrices();
         textView.setText("总价:￥"+priceAll);

         //设置总数量
        int numberAll = shopingExpandAdapter.changedAllNumber();
        button.setText("结算("+numberAll+")");

    }

}

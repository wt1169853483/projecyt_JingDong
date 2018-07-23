package com.example.wangtao.project_jingdong.mvp.shoppingcart.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BaseFragment;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyLeftBean;
import com.example.wangtao.project_jingdong.mvp.homepage.view.activity.HomeActivity;
import com.example.wangtao.project_jingdong.mvp.indent.view.activity.IndentActivity;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.adapter.ShopingExpandAdapter;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingButBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingDeleteBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingUpdataBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.presenter.ShopingPresenter;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.view.iview.IShopingView;

import java.lang.annotation.Target;
import java.util.ArrayList;
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
    private SharedPreferences preferences;
    private String uid;
    private  List<ShopingBean.DataBean> list=new ArrayList<>();
    private Button numBaerBtn;

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
        //获取sharedpreferences
        preferences = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);

        uid = preferences.getString("uid", 71 + "");
        //获取组件
        expandableListView = view.findViewById(R.id.shoping_fragment_expandableListView);
        checkBox = view.findViewById(R.id.shoping_fragment_chieckboxAll);
        textView = view.findViewById(R.id.shoping_fragment_priceAll);
        //单击结算
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
        if (preferences.getBoolean("ischeck", false)) {
            presenter.getShopingPresenter(uid);
        }else{
            Toast.makeText(getContext(),"请先登录",Toast.LENGTH_LONG).show();
        }
    }

   //请求成功
    @Override
    public void getClassSuccess(final ShopingBean json) {
        final List<ShopingBean.DataBean> data = json.getData();
        list =data;
        shopingExpandAdapter = new ShopingExpandAdapter(list,getContext(),presenter);
        expandableListView.setAdapter(shopingExpandAdapter);

        refreshSelectedAndTotalPriceAndTotalNumber();
        shopingExpandAdapter.setOnShopingListener(new ShopingExpandAdapter.OnShopingListener() {
            @Override
            public void getListGroupParamChanged(int groupPoition) {
                     Boolean boole= shopingExpandAdapter.isOnParamGourpSelledSelected(groupPoition);
                     shopingExpandAdapter.changedGourpSelledSelected(groupPoition,!boole);
                     refreshSelectedAndTotalPriceAndTotalNumber();
                     shopingExpandAdapter.notifyDataSetChanged();

                     shopingExpandAdapter.refreshSelectedAndTotalPriceAndTotalLinew(groupPoition,!boole);
            }

            @Override
            public void getListchildParamChanged(int groupPoition, int childPoition) {
                shopingExpandAdapter.changedChildSelected(groupPoition,childPoition);
                //presenter.getShopingUpdataPresenter(uid+"",json.getData().get(groupPoition).getSellerid()+"",json.getData().get(groupPoition).getList().get(childPoition).getPid()+"",json.getData().get(groupPoition).getList().get(childPoition).getSelected()+"",10+"");
                refreshSelectedAndTotalPriceAndTotalNumber();
                shopingExpandAdapter.notifyDataSetChanged();

                shopingExpandAdapter.refreshSelectedAndTotalPriceAndTotalChildLinew(groupPoition,childPoition);

            }

            @Override
            public void getListchildNumberChanged(int groupPoition, int childPoition, int number) {
                shopingExpandAdapter.changedChildSelectedNumber(groupPoition, childPoition, number);
               // presenter.getShopingUpdataPresenter(uid+"",json.getData().get(groupPoition).getSellerid()+"",json.getData().get(groupPoition).getList().get(childPoition).getPid()+"",json.getData().get(groupPoition).getList().get(childPoition).getSelected()+"",10+"");
                refreshSelectedAndTotalPriceAndTotalNumber();
                shopingExpandAdapter.notifyDataSetChanged();

                shopingExpandAdapter.refreshSelectedAndTotalPriceAndTotalNumberLinew(groupPoition,childPoition,number);

            }
        });
        //展开二级列表
        for (int i = 0; i < data.size(); i++) {
            expandableListView.expandGroup(i);
        }
        expandableListView.setGroupIndicator(null);
        //单击结算

    }

    @Override
    public void getUpdataClassSuccess(ShopingUpdataBean json) {

    }
     //删除成功
    @Override
    public void getDeleteClassSuccess(ShopingDeleteBean json) {
        String code = json.getCode();
        if (code.equalsIgnoreCase("0")){
                Toast.makeText(getActivity(),"删除成功",Toast.LENGTH_SHORT).show();
            //"16443"
                presenter.getShopingPresenter(uid);
        }
    }

    @Override
    public void getButClassSuccess(ShopingButBean json) {
                if (json.getCode().equalsIgnoreCase("0")){
                       Toast.makeText(getContext(),"加入订单成功",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getContext(), IndentActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getContext(),"加入订单失败",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getContext(), IndentActivity.class);
                    startActivity(intent);
                }
    }


    @Override
    public void getClassError(String error) {
        if (shopingExpandAdapter != null){
              list.clear();
              shopingExpandAdapter.notifyDataSetChanged();
        }
    }

    //计算总价
    public void refreshSelectedAndTotalPriceAndTotalNumber(){
        //设置全选全不选
        Boolean boole= shopingExpandAdapter.isAllProductsSelected();
        checkBox.setChecked(boole);
         //设置总价
        final int priceAll = shopingExpandAdapter.changedAllPrices();
         textView.setText("总价:￥"+priceAll);
       if (priceAll >0){
           button.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   presenter.getShopingButPresenter(uid,priceAll+"");
               }
           });
       }else{
            Toast.makeText(getContext(),"请先勾选",Toast.LENGTH_LONG).show();
       }
         //设置总数量
        int numberAll = shopingExpandAdapter.changedAllNumber();
        button.setText("结算("+numberAll+")");

    }

}

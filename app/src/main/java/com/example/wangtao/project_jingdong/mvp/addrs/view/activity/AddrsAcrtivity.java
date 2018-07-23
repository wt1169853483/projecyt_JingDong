package com.example.wangtao.project_jingdong.mvp.addrs.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BaseActivity;
import com.example.wangtao.project_jingdong.mvp.addrs.model.adapter.AddrsAdapter;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsAddBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsDefaultBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsSetBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsUpdataBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsUserBean;
import com.example.wangtao.project_jingdong.mvp.addrs.presenter.AddrsPresenter;
import com.example.wangtao.project_jingdong.mvp.addrs.view.iview.IAddrsView;
import com.example.wangtao.project_jingdong.mvp.homepage.model.adapter.RectcleMiaoshaAdapter;
import com.example.wangtao.project_jingdong.utils.mytitle.MyTitleView;

import java.util.List;

public class AddrsAcrtivity extends BaseActivity<AddrsPresenter> implements IAddrsView {

    private String uid;
    private RecyclerView recyclerView;
    private Button addBtn;
    private MyTitleView myTitleView;

    @Override
    protected int protetedId() {
        return R.layout.activity_addrs_acrtivity;
    }

    @Override
    protected void initView() {
        SharedPreferences sharedPreferences = getSharedPreferences("name", MODE_PRIVATE);
        uid = sharedPreferences.getString("uid","");
        //获取组件
        recyclerView = findViewById(R.id.addrs_activity_recycle);
        addBtn = findViewById(R.id.addrs_activity_add);
        myTitleView = findViewById(R.id.activity_addrs_activity_mytilte );
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected AddrsPresenter proPresenter() {
        return new AddrsPresenter(this);
    }

    @Override
    protected void initData() {
           presenter.getUserAddrPresenter(uid);
        myTitleView.setOnMyTitleViewClickListener(new MyTitleView.OnMyTitleViewClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void searchClick() {

            }

            @Override
            public void rightClick() {

            }
        });
    }

    @Override
    public void getDataSuccess(AddrsDefaultBean json) {

    }

    @Override
    public void getUserSuccess(AddrsUserBean json) {
        final List<AddrsUserBean.DataBean> data = json.getData();
        AddrsAdapter addrsAdapter=new AddrsAdapter(data,AddrsAcrtivity.this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(AddrsAcrtivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(addrsAdapter);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddrsAcrtivity.this,AddAddrsActivity.class);
                startActivityForResult(intent,6);
            }
        });
        addrsAdapter.setOnClickListener(new AddrsAdapter.OnClickListener() {
            @Override
            public void Onclick(int position) {
                Intent intent=new Intent(AddrsAcrtivity.this,AddrsUpdatasActivity.class);
                intent.putExtra("addrid",data.get(position).getAddrid());
                //int mobile = (int)data.get(position).getMobile();
                intent.putExtra("mobile",data.get(position).getMobile()+"");

                Log.e("tag", "Onclick:++++++++ "+data.get(position).getMobile() );
                intent.putExtra("name",data.get(position).getName());
                intent.putExtra("addr",data.get(position).getAddr());
                startActivityForResult(intent,6);
            }

            @Override
            public void CheckBoxOnclick(int position) {
                if (data.get(position).getStatus() == 1){
                    Toast.makeText(AddrsAcrtivity.this,"你已经选中了",Toast.LENGTH_SHORT).show();
                }else{
                    presenter.getSetAddrPresenter(uid,data.get(position).getAddrid()+"",1+"");
                }
            }
        });

    }

    @Override
    public void getAddSuccess(AddrsAddBean json) {

    }

    @Override
    public void getUpdataSuccess(AddrsUpdataBean json) {

    }

    @Override
    public void getSetSuccess(AddrsSetBean json) {
               if (json.getCode().equalsIgnoreCase("0")){
                   Toast.makeText(AddrsAcrtivity.this,"修改成功",Toast.LENGTH_SHORT).show();
                   initData();
                   Intent intent = getIntent();
                   setResult(1,intent);
                   finish();
               }
    }

    @Override
    public void getDataError(String error) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 6&& resultCode == 1  ){
                 initData();
        }
        if (requestCode == 6&& resultCode == 2  ){
                 initData();
        }
    }
}

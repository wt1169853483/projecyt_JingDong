package com.example.wangtao.project_jingdong.mvp.addrs.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BaseActivity;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsAddBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsDefaultBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsSetBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsUpdataBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsUserBean;
import com.example.wangtao.project_jingdong.mvp.addrs.presenter.AddrsPresenter;
import com.example.wangtao.project_jingdong.mvp.addrs.view.iview.IAddrsView;

public class AddrsUpdatasActivity extends BaseActivity<AddrsPresenter> implements IAddrsView {
    private EditText namesEdit;
    private EditText phoneEdit;
    private EditText addrsEdit;
    private Button button;
    private String uid;
    private Intent intent;
    private int addrid;

    @Override
    protected int protetedId() {
        return R.layout.activity_addrs_updatas;
    }

    @Override
    protected void initView() {
        SharedPreferences name = getSharedPreferences("name", MODE_PRIVATE);
        uid = name.getString("uid","");
        namesEdit = findViewById(R.id.activity_updata_addrs_names);
        phoneEdit = findViewById(R.id.activity_updata_addrs_phone);
        addrsEdit = findViewById(R.id.activity_updata_addrs_addrs);
        button = findViewById(R.id.activity_updata_addrs_baocun);
        intent = getIntent();
        addrid = intent.getIntExtra("addrid", 0);
        String mobile = intent.getStringExtra("mobile");
        Log.e("tag", "initView: "+mobile );
        String name1 = intent.getStringExtra("name");
        String addr = intent.getStringExtra("addr");
        namesEdit.setText(name1);
        phoneEdit.setText(mobile+"");
        addrsEdit.setText(addr);
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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = namesEdit.getText().toString().trim();
                String phone = phoneEdit.getText().toString().trim();
                String addrs = addrsEdit.getText().toString().trim();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(phone)&&!TextUtils.isEmpty(addrs)){
                    Log.e("tag", "onClick: gdjhagdshg"+name+phone +addrs);
                    presenter.getUpdataAddrPresenter(uid,addrid+"",phone,name,addrs);
                }else{
                    Toast.makeText(AddrsUpdatasActivity.this,"不能为空",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void getDataSuccess(AddrsDefaultBean json) {

    }

    @Override
    public void getUserSuccess(AddrsUserBean json) {

    }

    @Override
    public void getAddSuccess(AddrsAddBean json) {

    }

    @Override
    public void getUpdataSuccess(AddrsUpdataBean json) {
            if (json.getCode().equalsIgnoreCase("0")){
                   setResult(2,intent);
                   finish();
            }
    }

    @Override
    public void getSetSuccess(AddrsSetBean json) {

    }

    @Override
    public void getDataError(String error) {

    }
}

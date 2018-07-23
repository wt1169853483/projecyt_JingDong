package com.example.wangtao.project_jingdong.mvp.mine.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BaseActivity;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineLoginBean;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineRegBean;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineUploadBean;
import com.example.wangtao.project_jingdong.mvp.mine.presenter.MinePresenter;
import com.example.wangtao.project_jingdong.mvp.mine.view.iview.IMineView;
import com.example.wangtao.project_jingdong.utils.mytitle.MyTitleView;

public class MineRegActivity extends BaseActivity<MinePresenter> implements IMineView {

    private EditText userName;
    private EditText pwd;
    private EditText emile;
    private Button regBtn;
    private String emiles;
    private String password;
    private String uNmae;
    private MyTitleView myTitleView;

    @Override
    protected int protetedId() {
        return R.layout.mine_fragment_reg;
    }
    @Override
    protected MinePresenter proPresenter() {
        return new MinePresenter(this);
    }
    @Override
    protected void initView() {
          //获取组件

        userName = findViewById(R.id.mine_fragment_reg_userName);
        pwd = findViewById(R.id.mine_fragment_reg_pwd);
        emile = findViewById(R.id.mine_fragment_reg_emile);
        regBtn = findViewById(R.id.mine_fragment_reg_loginBtn);
        myTitleView = findViewById(R.id.mine_fragment_reg_mytilte);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

        regBtn.setOnClickListener(new View.OnClickListener() {

            @Override
              public void onClick(View v) {
                uNmae = userName.getText().toString().trim();
                password = pwd.getText().toString().trim();
                emiles = emile.getText().toString().trim();
                    if (uNmae != ""  && uNmae.length()!=0 && password != ""  && password.length()!=0&& emiles != ""  && emiles.length()!=0){
                          presenter.getMineRegPresenter(uNmae, password);
                    }else{
                        Toast.makeText(MineRegActivity.this,"证号密码邮箱",Toast.LENGTH_SHORT).show();
                    }
              }
          });
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
    public void getMineSuccess(MineLoginBean json) {

    }

    @Override
    public void getMineError(String error) {

    }

    @Override
    public void RegMineSuccess(MineRegBean json) {
             if (json.getCode().equalsIgnoreCase("0")){
                 Toast.makeText(MineRegActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                 Intent intent = getIntent();
                 intent.putExtra("uname",uNmae);
                 intent.putExtra("password",password);
                 setResult(2,intent);
                 finish();
             }else{
                 Toast.makeText(MineRegActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
             }
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

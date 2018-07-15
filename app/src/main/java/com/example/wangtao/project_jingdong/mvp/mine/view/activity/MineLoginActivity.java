package com.example.wangtao.project_jingdong.mvp.mine.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BaseActivity;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineLoginBean;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineRegBean;
import com.example.wangtao.project_jingdong.mvp.mine.presenter.MinePresenter;
import com.example.wangtao.project_jingdong.mvp.mine.view.iview.IMineView;

public class MineLoginActivity extends BaseActivity<MinePresenter> implements IMineView {
    private static final String TAG = "MineLoginActivity";
    private EditText usetname;
    private EditText pwd;
    private Button loginBtn;
    private String uname;
    private String password;
    private TextView regText;

    @Override
    protected int protetedId() {
        return R.layout.mine_fragment_login;
    }
    @Override
    protected MinePresenter proPresenter() {
        return new MinePresenter(this);
    }
    @Override
    protected void initView() {
          //获取组件
        usetname = findViewById(R.id.mine_fragment_login_userName);
        pwd = findViewById(R.id.mine_fragment_login_pwd);
        loginBtn = findViewById(R.id.mine_fragment_login_loginBtn);
        regText = findViewById(R.id.mine_fragment_login_reg);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname = usetname.getText().toString().trim();
                password = pwd.getText().toString().trim();
                if (uname != "" && uname.length() != 0 && password != "" && password.length() !=0){
                    Log.d(TAG, "onClick:++++++++++ "+uname);
                    Log.d(TAG, "onClick: ============="+password);
                    presenter.getMineLoginPresenter(uname, password);

                }else{
                    Toast.makeText(MineLoginActivity.this,"证号密码不能为空",Toast.LENGTH_SHORT).show();
                }

            }
        });
        regText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   Intent intent=new Intent(MineLoginActivity.this,MineRegActivity.class);
                   startActivityForResult(intent,2);
            }
        });
    }

    @Override
    public void getMineSuccess(MineLoginBean json) {

        MineLoginBean.DataBean data = json.getData();
        if (json.getCode().equalsIgnoreCase("0")){
            Toast.makeText(MineLoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();

            Intent intent = getIntent();
            intent.putExtra("userName",json.getData().getUsername());
            intent.putExtra("image",json.getData().getIcon()+"");
            setResult(1,intent);
            finish();
        }else{
            Toast.makeText(MineLoginActivity.this,"证号密码不正确",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getMineError(String error) {

    }

    @Override
    public void RegMineSuccess(MineRegBean json) {

    }

    @Override
    public void RegMineError(String error) {

    }

    @Override
    public void onFaild(String onfaild) {
        Toast.makeText(MineLoginActivity.this,onfaild,Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==2 && resultCode == 2){
            String uNmae = data.getStringExtra("uname");
            String password = data.getStringExtra("password");
            usetname.setText(uNmae);
            pwd.setText(password);
        }
    }
}

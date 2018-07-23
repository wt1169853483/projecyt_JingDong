package com.example.wangtao.project_jingdong.mvp.homepage.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BaseActivity;
import com.example.wangtao.project_jingdong.mvp.homepage.model.adapter.HomeSearchRecycleAdapter;
import com.example.wangtao.project_jingdong.mvp.homepage.model.adapter.RectcleMiaoshaAdapter;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeButBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeSearchBean;
import com.example.wangtao.project_jingdong.mvp.homepage.presenter.HomeSearchPresenter;
import com.example.wangtao.project_jingdong.mvp.homepage.view.iview.IHomeSearch;
import com.example.wangtao.project_jingdong.mvp.homepage.view.iview.MyFlowLayout;

import org.w3c.dom.Text;

import java.util.List;

public class HomeSearchActivity extends BaseActivity<HomeSearchPresenter> implements IHomeSearch {

    private EditText nameEdit;
    private Button searchBtn;
    private MyFlowLayout myFlowLayout;
    private LinearLayout linearLayout;
    private Button morenBtn;
    private Button xiaoliangBtn;
    private Button jiageBtn;
    private RecyclerView recyclerView;
    private String nameText;
    private ImageButton imageButton;

    @Override
    protected int protetedId() {
        return R.layout.activity_home_search;
    }
    @Override
    protected HomeSearchPresenter proPresenter() {
        return new HomeSearchPresenter(this);
    }
    @Override
    protected void initView() {
        nameEdit = findViewById(R.id.activity_home_search_edittext);
        searchBtn = findViewById(R.id.activity_home_search_sousuo_btn);
        myFlowLayout = findViewById(R.id.activity_home_search_sousuo_flowlayout);

        linearLayout = findViewById(R.id.activity_home_search_sousuo_layout);
        morenBtn = findViewById(R.id.activity_home_search_sousuo_moren);
        xiaoliangBtn = findViewById(R.id.activity_home_search_sousuo_xiaoliang);
        jiageBtn = findViewById(R.id.activity_home_search_sousuo_jiage);
        recyclerView = findViewById(R.id.activity_home_search_search_recycles);

        myFlowLayout.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.GONE);
        imageButton = findViewById(R.id.activity_home_search_imageBtan);
    }

    @Override
    protected void initListener() {

    }
    @Override
    protected void initData() {
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameText = nameEdit.getText().toString().trim();
                if (nameText.length() != 0 && nameText != "") {

                    TextView textView = new TextView(HomeSearchActivity.this);
                    textView.setText(nameText);
                    textView.setPadding(10, 10, 10, 10);
                    textView.setTextSize(20);
                    myFlowLayout.addView(textView);
                    presenter.getSearchPresenter(nameText,"1","0");
                    myFlowLayout.setVisibility(View.GONE);
                    linearLayout.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(HomeSearchActivity.this, "不能为空", Toast.LENGTH_LONG).show();
                }
            }
        });
        int childCount = myFlowLayout.getChildCount();
        for (int i = 0; i <childCount ; i++) {
            final TextView childAt = (TextView) myFlowLayout.getChildAt(i);
            childAt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   nameText= childAt.getText().toString();
                    presenter.getSearchPresenter(nameText,"1","0");
                    myFlowLayout.setVisibility(View.GONE);
                    linearLayout.setVisibility(View.VISIBLE);

                }
            });
        }
        morenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getSearchPresenter(nameText,"1","0");
            }
        });
        xiaoliangBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getSearchPresenter(nameText,"1","1");
            }
        });
        jiageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getSearchPresenter(nameText,"1","2");
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void getHomeSuccess(HomeSearchBean json) {
        final List<HomeSearchBean.DataBean> data = json.getData();
        HomeSearchRecycleAdapter homeSearchRecycleAdapter =new HomeSearchRecycleAdapter(data);
        recyclerView.setAdapter(homeSearchRecycleAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(HomeSearchActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        homeSearchRecycleAdapter.setOnClickListener(new RectcleMiaoshaAdapter.OnClickListener() {
            @Override
            public void Onclick(int position) {
                Intent intent=new Intent(HomeSearchActivity.this,HomeActivity.class);
                intent.putExtra("position",data.get(position).getPid());
                startActivity(intent);
            }
        });
    }

    @Override
    public void getButHomeSuccess(HomeButBean json) {

    }

    @Override
    public void getHomeError(String error) {
            
    }
    /* R.layout.activity_home_search*/
}

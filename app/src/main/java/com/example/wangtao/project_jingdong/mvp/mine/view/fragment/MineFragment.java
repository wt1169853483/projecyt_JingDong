package com.example.wangtao.project_jingdong.mvp.mine.view.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.mvp.mine.model.adapter.MyRecycleAdapterdd;
import com.example.wangtao.project_jingdong.mvp.mine.model.adapter.MyRecycleAdaptergd;
import com.example.wangtao.project_jingdong.mvp.mine.view.activity.MineLoginActivity;
import com.example.wangtao.project_jingdong.mvp.mine.view.activity.MineinformActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.scwang.smartrefresh.header.FlyRefreshHeader;
import com.scwang.smartrefresh.header.WaveSwipeHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class MineFragment extends Fragment {

    //15035404355
    private View view;
    private RefreshLayout refreshLayout;
    private ImageButton imageButton;
    private TextView uname;

    private List<Integer> listPic_dd;
    private List<String> listTitle_dd;
    private List<Integer> listPic_gd;
    private List<String> listTitle_gd;
    private RecyclerView recyclerView_dd;
    private RecyclerView recyclerView_gd;
    private SimpleDraweeView simpleDraweeView;
    private ImageView infoImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mine_fragment,container,false);
         initView();
        return view;
    }

    private void initView() {
        recyclerView_dd = view.findViewById(R.id.mine_fragment_login_recycleView);
        recyclerView_gd = view.findViewById(R.id.mine_fragment_login_recycleView_gd);
        simpleDraweeView = view.findViewById(R.id.mine_fragment_imageButton);
        infoImage = view.findViewById(R.id.mine_fragment_login_info_image);
        //获取点击事件
        uname = view.findViewById(R.id.mine_fragment_uanme);

        initData();
    }

    private void initData() {

        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("name", MODE_PRIVATE);
        boolean ischeck = sharedPreferences.getBoolean("ischeck", false);
        if (ischeck){
            String username = sharedPreferences.getString("username", "");
            String image = sharedPreferences.getString("image", "");
            uname.setText(username);
            Uri uri=Uri.parse(image);
            simpleDraweeView.setImageURI(uri);

            simpleDraweeView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getContext(), MineinformActivity.class);
                    startActivityForResult(intent,3);
                    //startActivity(intent);

                }
            });
            uname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getContext(), MineinformActivity.class);
                    startActivityForResult(intent,3);
                }
            });
        }else{
            simpleDraweeView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getContext(), MineLoginActivity.class);
                    startActivityForResult(intent,1);
                    //startActivity(intent);

                }
            });
            uname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getContext(), MineinformActivity.class);
                    startActivityForResult(intent,3);
                }
            });
        }

        infoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MineinformActivity.class);
                startActivityForResult(intent,1);
            }
        });
        listPic_dd = new ArrayList<>();
        listPic_dd.add(R.drawable.dianpu);
        listPic_dd.add(R.drawable.dsh);
        listPic_dd.add(R.drawable.dpj);
        listPic_dd.add(R.drawable.th_sh);
        listPic_dd.add(R.drawable.mydd);

        listTitle_dd = new ArrayList<>();
        listTitle_dd.add("待付款");
        listTitle_dd.add("待收货");
        listTitle_dd.add("待评价");
        listTitle_dd.add("退货/售后");
        listTitle_dd.add("我的订单");
        listPic_gd = new ArrayList<>();
        listPic_gd.add(R.drawable.dp);
        listPic_gd.add(R.drawable.kh);
        listPic_gd.add(R.drawable.hd);
        listPic_gd.add(R.drawable.spgz);
        listPic_gd.add(R.drawable.gz);

        listTitle_gd = new ArrayList<>();
        listTitle_gd.add("店铺");
        listTitle_gd.add("客服");
        listTitle_gd.add("活动");
        listTitle_gd.add("超市");
        listTitle_gd.add("收藏");

        MyRecycleAdapterdd myRecycle_dd = new MyRecycleAdapterdd(listPic_dd, listTitle_dd,getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_dd.setLayoutManager(linearLayoutManager);
        recyclerView_dd.setAdapter(myRecycle_dd);

        MyRecycleAdaptergd myRecycle_gd = new MyRecycleAdaptergd(listPic_gd, listTitle_gd);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_gd.setLayoutManager(linearLayoutManager1);
        recyclerView_gd.setAdapter(myRecycle_gd);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==1 && requestCode == 1){
            SharedPreferences sharedPreferences=getActivity().getSharedPreferences("name", MODE_PRIVATE);
            //boolean ischeck = sharedPreferences.getBoolean("ischeck", false);
            String username = sharedPreferences.getString("username", "");
            String image = sharedPreferences.getString("image", "");
            uname.setText(username);
            Uri uri=Uri.parse(image);
            simpleDraweeView.setImageURI(uri);
            initData();
        }
        if (requestCode ==3 && requestCode == 3){
            SharedPreferences sharedPreferences=getActivity().getSharedPreferences("name", MODE_PRIVATE);
            String username = sharedPreferences.getString("username", "");
            String image = sharedPreferences.getString("image", "");
          // String image = sharedPreferences.getSt
            // ring("image", "");
            uname.setText(username);
            Uri uri=Uri.parse(image);
            simpleDraweeView.setImageURI(uri);
           /* Intent intent=new Intent(getContext(), MineLoginActivity.class);
            startActivityForResult(intent,4);*/
            initData();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("name", MODE_PRIVATE);
       // String username = sharedPreferences.getString("username", "");
        String image = sharedPreferences.getString("image", "");
        Uri uri=Uri.parse(image);
        simpleDraweeView.setImageURI(uri);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }
}

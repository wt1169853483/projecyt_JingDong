package com.example.wangtao.project_jingdong.mvp.homepage.view.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BaseFragment;
import com.example.wangtao.project_jingdong.mvp.homepage.model.adapter.HomeRecycleAdapter;
import com.example.wangtao.project_jingdong.mvp.homepage.model.adapter.RectcleMiaoshaAdapter;
import com.example.wangtao.project_jingdong.mvp.homepage.model.adapter.RectcleTuijianAdapter;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeButBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeCatagoryBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomePidBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeUtilBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeaddCarBean;
import com.example.wangtao.project_jingdong.mvp.homepage.presenter.HomePresenter;
import com.example.wangtao.project_jingdong.mvp.homepage.view.activity.HomeActivity;
import com.example.wangtao.project_jingdong.mvp.homepage.view.activity.HomeSearchActivity;
import com.example.wangtao.project_jingdong.mvp.homepage.view.iview.HomeIview;
import com.example.wangtao.project_jingdong.mvp.mainpage.view.activity.MainActivity;
import com.example.wangtao.project_jingdong.mvp.mainpage.view.activity.ShowActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.scwang.smartrefresh.header.WaveSwipeHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.sunfusheng.marqueeview.MarqueeView;
import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements HomeIview{
    private static final String TAG = "HomeFragment";
    private List<String> bannerList=new ArrayList<>();
    private Banner banner;
    private RecyclerView catagoryRecycle;
    private RecyclerView miaoshaRecycle;
    private RecyclerView tuijianRecycle;
    private RefreshLayout refreshLayout;
    private MarqueeView marqueeView;
    private EditText editText;
    private ImageButton imageButton;
    @Override
    protected int protetedId() {
        return R.layout.home_fragment;
    }

    @Override
    protected HomePresenter proPresenter() {
        return new HomePresenter(this);
    }
    @Override
    protected void initView(View view) {
       //获取组件
        banner = view.findViewById(R.id.home_fragment_beanner);
        catagoryRecycle = view.findViewById(R.id.home_fragment_recycle_catagory);
        miaoshaRecycle = view.findViewById(R.id.home_fragment_recycle_miaosha);
        tuijianRecycle = view.findViewById(R.id.home_fragment_recycle_tuijian);
        refreshLayout = view.findViewById(R.id.home_fragment_refreshLayout);
        marqueeView = view.findViewById(R.id.home_fragment_marqueeView);
        //获取搜索框
        editText = view.findViewById(R.id.home_fragment_sousuo_editText);
        imageButton=view.findViewById(R.id.home_fragment_imageBtn);
    }

    @Override
    protected void initListener() {

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });

//设置 Header 为 贝塞尔雷达 样式
        refreshLayout.setRefreshHeader(new WaveSwipeHeader(getContext()));
//设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(getContext()).setSpinnerStyle(SpinnerStyle.Scale));
    }

    @Override
    protected void initData() {
         presenter.getHomePresenter();
        List<String> info = new ArrayList<>();
        info.add("开讲啦!!!!!!!!!!!!!!!!");
        info.add("大减价啦!!!!!!!!!!!!!!!!");
        info.add("小猴股!!!!!!!!!!!!!!!!");
        info.add("开奖了!!!!!!!!!!!!!!!!");
      // 在代码里设置自己的动画
        marqueeView.startWithList(info, R.anim.anim_bottom_in, R.anim.anim_top_out);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Intent intent=new Intent(getContext(), HomeSearchActivity.class);
                  startActivity(intent);
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    // 申请CAMERA权限
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, 1);
                }else{
                    // 打开扫描界面扫描条形码或二维码
                    Intent openCameraIntent = new Intent(getContext(), CaptureActivity.class);
                    startActivityForResult(openCameraIntent, 0);
                }
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(1 == requestCode) {
            // 打开扫描界面扫描条形码或二维码
            Intent openCameraIntent = new Intent(getContext(), CaptureActivity.class);
            startActivityForResult(openCameraIntent, 0);
        }
    }

    @Override
    public void getHomeSuccess(HomeUtilBean json) {
        //设置轮播图
        List<HomeUtilBean.DataBean> data = json.getData();
        for (int i = 0; i <data.size() ; i++) {
            String icon = data.get(i).getIcon();
            bannerList.add(icon);
        }
        banner.setImageLoader(new GlideImageloader());
        banner.setImages(bannerList);
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        banner.start();

        //设置秒杀
        final HomeUtilBean.MiaoshaBean miaosha = json.getMiaosha();
        final List<HomeUtilBean.MiaoshaBean.ListBeanX> miaoshaList = miaosha.getList();

        RectcleMiaoshaAdapter rectcleMiaoshaAdapter=new RectcleMiaoshaAdapter(miaoshaList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        miaoshaRecycle.setLayoutManager(linearLayoutManager);
        miaoshaRecycle.setAdapter(rectcleMiaoshaAdapter);

        rectcleMiaoshaAdapter.setOnClickListener(new RectcleMiaoshaAdapter.OnClickListener() {
            @Override
            public void Onclick(int position) {
                int pid = miaoshaList.get(position).getPid();
                //Log.d(TAG, "Onclick: 秒杀+++++++++++++++"+pid);
                Intent intent=new Intent(getContext(), HomeActivity.class);
                intent.putExtra("position",pid);
                startActivityForResult(intent,666);
            }
        });

        //设置推荐
        final HomeUtilBean.TuijianBean tuijian = json.getTuijian();
        final List<HomeUtilBean.TuijianBean.ListBean> list = tuijian.getList();
        RectcleTuijianAdapter rectcleTuijianAdapter=new RectcleTuijianAdapter(list);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        tuijianRecycle.setLayoutManager(gridLayoutManager);
        tuijianRecycle.setAdapter(rectcleTuijianAdapter);
        rectcleTuijianAdapter.setOnclickListener(new RectcleTuijianAdapter.OnClickListener() {
            @Override
            public void onclick(int position) {
                Intent intent=new Intent(getContext(), HomeActivity.class);
                int pid = list.get(position).getPid();
               // Log.d(TAG, "onclick:++++++++++++++++++++推荐 "+pid);
                intent.putExtra("position",pid);
                startActivityForResult(intent,666);
            }
        });
    }

    @Override
    public void getHomeError(String error) {

    }

    @Override
    public void getCatagorySuccess(HomeCatagoryBean json) {
        List<HomeCatagoryBean.DataBean> data = json.getData();

        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        catagoryRecycle.setLayoutManager(gridLayoutManager);

        HomeRecycleAdapter homeRecycleAdapter=new HomeRecycleAdapter(data);
        catagoryRecycle.setAdapter(homeRecycleAdapter);

    }


    @Override
    public void getCatagoryError(String error) {

    }

    @Override
    public void getDataSuccess(HomeaddCarBean json) {
           
    }

    @Override
    public void getDataError(String error) {

    }

    @Override
    public void getPidDataSuccess(HomePidBean json) {

    }

    @Override
    public void getPidDataError(String error) {

    }

    @Override
    public void getButHomeSuccess(HomeButBean json) {

    }


    //banner控制类
    public class GlideImageloader extends ImageLoader{

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Uri uri=Uri.parse((String) path);
            imageView.setImageURI(uri);
        }

        @Override
        public ImageView createImageView(Context context) {
            SimpleDraweeView simpleDraweeView=new SimpleDraweeView(context);
            return simpleDraweeView;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 666 && resultCode == 666){
            ShowActivity showActivity = (ShowActivity) getActivity();
            showActivity.InitShoping();
            showActivity.getBottomBar().setDefaultTab(R.id.tab_shoping);
        }
    }

}

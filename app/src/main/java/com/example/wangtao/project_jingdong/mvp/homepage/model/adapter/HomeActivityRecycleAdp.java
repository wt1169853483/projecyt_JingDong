package com.example.wangtao.project_jingdong.mvp.homepage.model.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomePidBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeUtilBean;
import com.example.wangtao.project_jingdong.mvp.homepage.presenter.HomePresenter;
import com.example.wangtao.project_jingdong.mvp.mainpage.view.activity.ShowActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangtao on 2018/7/13.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class HomeActivityRecycleAdp extends RecyclerView.Adapter<HomeActivityRecycleAdp.MyViewHolder> {
    private HomePidBean.DataBean listBean;
    private Context context;
    private HomePresenter homePresenter;
    private List<String> imageList;

    public HomeActivityRecycleAdp(HomePidBean.DataBean listBean, Context context, HomePresenter homePresenter) {
        this.listBean = listBean;
        this.context = context;
        this.homePresenter = homePresenter;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_activity_recycle_child, parent, false);
        MyViewHolder myViewHolder=new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        imageList = new ArrayList<>();
          holder.textFanhui.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent=new Intent(context, ShowActivity.class);
                  context.startActivity(intent);
              }
          });
        String[] split = listBean.getImages().split("\\|");
        for (int i = 0; i <split.length ; i++) {
          imageList.add(split[i]);
        }
        holder.banner.setImageLoader(new GlideImageloader());
        holder.banner.setImages(imageList);
        holder.banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        holder.banner.start();

        holder.priceText.setText("￥"+listBean.getPrice()+"");
        holder.titleText.setText(listBean.getTitle()+"");
        holder.subheadText.setText(listBean.getSubhead()+"");
        holder. nameText.setText("");

        holder.addShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homePresenter.getHomeCarPresenter("16443",listBean.getPid()+"");
            }
        });

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textFanhui;
        Banner banner;
        Button addShow,buyShow;
        TextView priceText,titleText,subheadText,nameText;
        public MyViewHolder(View itemView) {
            super(itemView);
            textFanhui=itemView.findViewById(R.id.tv_back_show);
            banner=itemView.findViewById(R.id.iv_product_icon_show);
            priceText=itemView.findViewById(R.id.tv_product_price_show);
            titleText=itemView.findViewById(R.id.tv_product_title_show);
            subheadText=itemView.findViewById(R.id.tv_product_subhead_show);
            nameText=itemView.findViewById(R.id.tv_seller_name_show);
            addShow=itemView.findViewById(R.id.btn_add_product_show);
            buyShow=itemView.findViewById(R.id.btn_buy_product_show);
        }
    }

    public class GlideImageloader extends ImageLoader {

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
}

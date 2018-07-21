package com.example.wangtao.project_jingdong.mvp.discover.Model.adapter;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.NewsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by wangtao on 2018/7/18.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class DiscoverAndroidAdapter extends RecyclerView.Adapter{
   private List<NewsBean.ResultBean.DataBean> list;

    public DiscoverAndroidAdapter(List<NewsBean.ResultBean.DataBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1){
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.discover_fragment_android_line, parent, false);
            MyViewHolder myViewHolder=new MyViewHolder(inflate);
            return myViewHolder;
        }else{
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.discover_fragment_android_vercal, parent, false);
            MyvercalViewHolder  myvercalViewHolder=new MyvercalViewHolder(inflate);
            return myvercalViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
          if (holder instanceof MyViewHolder){
              MyViewHolder myViewHolder =(MyViewHolder) holder;
              myViewHolder.titleText.setText(list.get(position).getTitle());
              myViewHolder.simpleDraweeView.setImageURI(list.get(position).getThumbnail_pic_s());
          }else if (holder instanceof MyvercalViewHolder){
              MyvercalViewHolder myvercalViewHolder =(MyvercalViewHolder) holder;
              myvercalViewHolder.titleText.setText(list.get(position).getTitle());
              myvercalViewHolder.simpleDraweeView.setImageURI(list.get(position).getThumbnail_pic_s());
              Uri uri=Uri.parse(list.get(position).getThumbnail_pic_s02());
              Uri uri1=Uri.parse(list.get(position).getThumbnail_pic_s03());
              myvercalViewHolder.simpleDraweeView1.setImageURI(uri);
              myvercalViewHolder.simpleDraweeView2.setImageURI(uri1);
          }
    }

    @Override
    public int getItemViewType(int position) {
        String thumbnail_pic_s03 = list.get(position).getThumbnail_pic_s03();
        if (!TextUtils.isEmpty(thumbnail_pic_s03)){
            return 0;
          }else{
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return list!= null ? list.size():0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView simpleDraweeView;
        private TextView titleText;
        public MyViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.discover_fragment_andorid_line_simp);
            titleText=itemView.findViewById(R.id.discover_fragment_andorid_line_title);
        }
    }
    public class MyvercalViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView simpleDraweeView,simpleDraweeView1,simpleDraweeView2;
        private TextView titleText;
        public MyvercalViewHolder(View itemView) {
            super(itemView);
            titleText=itemView.findViewById(R.id.discover_fragment_andorid_vercal_title);
            simpleDraweeView=itemView.findViewById(R.id.discover_fragment_andorid_vercal_simple);
            simpleDraweeView1=itemView.findViewById(R.id.discover_fragment_andorid_vercal_simple1);
            simpleDraweeView2=itemView.findViewById(R.id.discover_fragment_andorid_vercal_simple2);
        }
    }
}

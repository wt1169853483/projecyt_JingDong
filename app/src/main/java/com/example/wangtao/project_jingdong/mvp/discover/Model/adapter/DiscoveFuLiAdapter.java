package com.example.wangtao.project_jingdong.mvp.discover.Model.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.FuliBean;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.NewsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by wangtao on 2018/7/18.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class DiscoveFuLiAdapter extends RecyclerView.Adapter<DiscoveFuLiAdapter.MyViewHolder>{
   private  List<FuliBean.NewslistBean> list;
  private Context context;

    public DiscoveFuLiAdapter(List<FuliBean.NewslistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.discover_fragment_fuli_adapter, parent, false);
        MyViewHolder myViewHolder=new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       // holder.simpleDraweeView.setImageURI(list.get(position).getPicUrl());
        Glide.with(context).load(list.get(position).getPicUrl()).into(holder.simpleDraweeView);
    }

    @Override
    public int getItemCount() {
        return list!= null ? list.size():0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView simpleDraweeView;
        public MyViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.discover_fragment_fuli_adapter_simple);
        }
    }

}

package com.example.wangtao.project_jingdong.mvp.discover.Model.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.FuliBean;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.ISOBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by wangtao on 2018/7/18.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class DiscoveISOAdapter extends RecyclerView.Adapter<DiscoveISOAdapter.MyViewHolder>{
   private   List<ISOBean.NewslistBean> list;
  private Context context;

    public DiscoveISOAdapter(List<ISOBean.NewslistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.discover_fragment_iso_adapter, parent, false);
        MyViewHolder myViewHolder=new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
           holder.title.setText(list.get(position).getTitle());
           holder.content.setText(list.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return list!= null ? list.size():0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView title,content;
        public MyViewHolder(View itemView) {
            super(itemView);
           title =itemView.findViewById(R.id.discover_fragment_iso_adapter_title);
           content =itemView.findViewById(R.id.discover_fragment_iso_adapter_content);
        }
    }

}

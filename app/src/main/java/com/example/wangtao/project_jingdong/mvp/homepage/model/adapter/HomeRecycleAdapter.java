package com.example.wangtao.project_jingdong.mvp.homepage.model.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeCatagoryBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class HomeRecycleAdapter extends RecyclerView.Adapter<HomeRecycleAdapter.MyViewHolder>{
    private List<HomeCatagoryBean.DataBean> list;

    public HomeRecycleAdapter(List<HomeCatagoryBean.DataBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_fragment_recycle, parent, false);
        MyViewHolder myViewHolder=new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
           holder.textView.setText(list.get(position).getName());
        String icon = list.get(position).getIcon();
        holder.simpleDraweeView.setImageURI(icon);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0:list.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder{
       private SimpleDraweeView simpleDraweeView;
       private TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.home_fragment_recyclers_gang_image);
            textView =itemView.findViewById(R.id.home_fragment_recyclers_gang_text);
        }
    }
}

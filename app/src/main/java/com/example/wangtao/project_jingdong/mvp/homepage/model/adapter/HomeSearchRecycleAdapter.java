package com.example.wangtao.project_jingdong.mvp.homepage.model.adapter;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeCatagoryBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeSearchBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class HomeSearchRecycleAdapter extends RecyclerView.Adapter<HomeSearchRecycleAdapter.MyViewHolder>{
    private List<HomeSearchBean.DataBean> list;

    public HomeSearchRecycleAdapter(List<HomeSearchBean.DataBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_fragment_search_recycle, parent, false);
        MyViewHolder myViewHolder=new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        String images = list.get(position).getImages();
        String[] split = images.split("\\|");
        Uri uri=Uri.parse(split[0]);
        holder.simpleDraweeView.setImageURI(uri);
        holder.titleView.setText(list.get(position).getTitle());
        holder.nameView.setText("￥"+list.get(position).getPrice());
        holder.simpleDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    onClickListener.Onclick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0:list.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder{
       private SimpleDraweeView simpleDraweeView;
       private TextView titleView,nameView;
        public MyViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.activity_home_search_recycle_sime);
            titleView =itemView.findViewById(R.id.activity_home_search_recycle_title);
            nameView =itemView.findViewById(R.id.activity_home_search_recycle_name);
        }
    }
    private RectcleMiaoshaAdapter.OnClickListener onClickListener;

    public void setOnClickListener(RectcleMiaoshaAdapter.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface  OnClickListener{
        public void Onclick(int position);
    }
}

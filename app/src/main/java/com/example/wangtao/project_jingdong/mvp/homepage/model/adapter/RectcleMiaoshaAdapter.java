package com.example.wangtao.project_jingdong.mvp.homepage.model.adapter;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeUtilBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by wangtao on 2018/7/12.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class RectcleMiaoshaAdapter extends RecyclerView.Adapter<RectcleMiaoshaAdapter.MyViewHolder>{
    private List<HomeUtilBean.MiaoshaBean.ListBeanX> list;

    public RectcleMiaoshaAdapter(List<HomeUtilBean.MiaoshaBean.ListBeanX> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_fragment_maiosha_recycle, parent, false);
        MyViewHolder myViewHolder=new MyViewHolder(inflate);
        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        String images = list.get(position).getImages();
        String[] split = images.split("\\|");
        Uri uri=Uri.parse(split[0]);
        holder.simpleDraweeView.setImageURI(uri);
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
        private  SimpleDraweeView simpleDraweeView;
         public MyViewHolder(View itemView) {
             super(itemView);
             simpleDraweeView =itemView.findViewById(R.id.home_fragment_recyclers_miaosha_image);

         }

     }
     private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface  OnClickListener{
           public void Onclick(int position);
     }
}

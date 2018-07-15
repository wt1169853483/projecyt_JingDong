package com.example.wangtao.project_jingdong.mvp.homepage.model.adapter;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
public class RectcleTuijianAdapter extends RecyclerView.Adapter<RectcleTuijianAdapter.MyViewHolder>{
    private List<HomeUtilBean.TuijianBean.ListBean> list;

    public RectcleTuijianAdapter(List<HomeUtilBean.TuijianBean.ListBean> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_fragment_tuijian_recycle, parent, false);
        MyViewHolder myViewHolder=new MyViewHolder(inflate);
        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        String images = list.get(position).getImages();
        String[] split = images.split("\\|");
        Uri uri=Uri.parse(split[0]);
        holder.simpleDraweeView.setImageURI(uri);

        holder.textView.setText(list.get(position).getTitle());
        holder.textView1.setText("￥"+list.get(position).getPrice()+"");
        holder.simpleDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   onClickListener.onclick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0:list.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder{
        private  SimpleDraweeView simpleDraweeView;
        private TextView textView;
        private TextView textView1;
         public MyViewHolder(View itemView) {
             super(itemView);
             simpleDraweeView =itemView.findViewById(R.id.home_fragment_tuijian_image);
             textView =itemView.findViewById(R.id.home_fragment_tuijian_title);
             textView1 =itemView.findViewById(R.id.home_fragment_tuijian_price);
         }
     }
     private OnClickListener onClickListener;

    public void setOnclickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
           void onclick(int position);
    }
}

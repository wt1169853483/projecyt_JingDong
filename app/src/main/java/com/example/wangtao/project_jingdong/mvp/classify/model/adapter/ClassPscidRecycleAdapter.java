package com.example.wangtao.project_jingdong.mvp.classify.model.adapter;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyPscidBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyRightBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.adapter.RectcleMiaoshaAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class ClassPscidRecycleAdapter extends RecyclerView.Adapter<ClassPscidRecycleAdapter.MyViewHolder>{
   private List<ClassifyPscidBean.DataBean>  list;

    public ClassPscidRecycleAdapter(List<ClassifyPscidBean.DataBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_classify_pscid_item, parent, false);
        MyViewHolder myViewHolder=new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
            holder.titleText.setText(list.get(position).getTitle());
            holder.priceText.setText("￥"+list.get(position).getPrice()+"");
        String images = list.get(position).getImages();
        String[] split = images.split("\\|");
        holder.simpleDraweeView.setImageURI(split[0]);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
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
       private TextView titleText,priceText;
       private SimpleDraweeView simpleDraweeView;
       private LinearLayout linearLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.activity_classify_pscid_simple);
            titleText=itemView.findViewById(R.id.activity_classify_pscid_title);
            priceText=itemView.findViewById(R.id.activity_classify_pscid_price);
            linearLayout =itemView.findViewById(R.id.pscid_linearLayour);
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

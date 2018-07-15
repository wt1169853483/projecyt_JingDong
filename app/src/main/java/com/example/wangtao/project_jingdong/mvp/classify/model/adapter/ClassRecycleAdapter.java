package com.example.wangtao.project_jingdong.mvp.classify.model.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyRightBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.adapter.RectcleMiaoshaAdapter;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeCatagoryBean;
import com.facebook.drawee.view.SimpleDraweeView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class ClassRecycleAdapter extends RecyclerView.Adapter<ClassRecycleAdapter.MyViewHolder>{
    List<ClassifyRightBean.DataBean.ListBean> list;

    public ClassRecycleAdapter(List<ClassifyRightBean.DataBean.ListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.classify_fragment_right_recycle_child_layout, parent, false);
        MyViewHolder myViewHolder=new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
           holder.textView.setText(list.get(position).getName());
        String icon = list.get(position).getIcon();
        Uri uri=Uri.parse(icon);
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
       private TextView textView;
       private SimpleDraweeView simpleDraweeView;
        public MyViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.classfiy_fragment_right_recycle_child_simple);
            textView=itemView.findViewById(R.id.classfiy_fragment_right_recycle_child_name);
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

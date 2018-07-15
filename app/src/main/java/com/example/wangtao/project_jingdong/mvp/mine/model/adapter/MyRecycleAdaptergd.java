package com.example.wangtao.project_jingdong.mvp.mine.model.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wangtao.project_jingdong.R;

import java.util.List;

/**
 * Created by wangtao on 2018/7/13.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class MyRecycleAdaptergd extends RecyclerView.Adapter<MyRecycleAdaptergd.MyViewHolder> {
    private List<Integer> listPic_dd;
    private List<String> listTitle_dd;

    public MyRecycleAdaptergd(List<Integer> listPic_dd, List<String> listTitle_dd) {
        this.listPic_dd = listPic_dd;
        this.listTitle_dd = listTitle_dd;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_fragment_adapter_gd, parent, false);
        MyViewHolder myViewHolder =new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
           holder.textView.setText(listTitle_dd.get(position));
           holder.imageView.setImageResource(listPic_dd.get(position));
    }

    @Override
    public int getItemCount() {
        return listPic_dd.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder{
         TextView textView;
         ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.mine_fragment_adapter_gd_nameText);
            imageView=itemView.findViewById(R.id.mine_fragment_adapter_gd_imageview);
        }
    }
}

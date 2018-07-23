package com.example.wangtao.project_jingdong.mvp.mine.model.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.mvp.addrs.view.activity.AddrsAcrtivity;
import com.example.wangtao.project_jingdong.mvp.indent.view.activity.IndentActivity;

import java.util.List;

/**
 * Created by wangtao on 2018/7/13.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class MyRecycleAdapterdd extends RecyclerView.Adapter<MyRecycleAdapterdd.MyViewHolder> {
    private List<Integer> listPic_gd;
    private List<String> listTitle_gd;
    private Context context;

    public MyRecycleAdapterdd(List<Integer> listPic_gd, List<String> listTitle_gd, Context context) {
        this.listPic_gd = listPic_gd;
        this.listTitle_gd = listTitle_gd;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_fragment_adapter_dd, parent, false);
        MyViewHolder myViewHolder =new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
           holder.textView.setText(listTitle_gd.get(position));
           holder.imageView.setImageResource(listPic_gd.get(position));
           if (position == 4){
               holder.imageView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent=new Intent(context, IndentActivity.class);
                       context.startActivity(intent);
                   }
               });
           }
        if (position == 1){
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, AddrsAcrtivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listTitle_gd.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder{
         TextView textView;
         ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.mine_fragment_adapter_nameText);
            imageView=itemView.findViewById(R.id.mine_fragment_adapter_imageview);
        }
    }
}

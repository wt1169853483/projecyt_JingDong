package com.example.wangtao.project_jingdong.mvp.indent.model.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.FuliBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.adapter.RectcleMiaoshaAdapter;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentBean;
import com.facebook.drawee.view.SimpleDraweeView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by wangtao on 2018/7/18.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class DiscoveIndentAdapter extends RecyclerView.Adapter<DiscoveIndentAdapter.MyViewHolder>{
   private  List<IndentBean.DataBean> list;
  private Context context;

    public DiscoveIndentAdapter(List<IndentBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.indent_fragment_but_adapter, parent, false);
        MyViewHolder myViewHolder=new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
           holder.time.setText(list.get(position).getCreatetime());
           holder.price.setText(list.get(position).getPrice()+"");
        int status = list.get(position).getStatus();
        if (status == 0){
              holder.btn.setText("待支付");
              holder.btn.setBackgroundColor(Color.RED);
            holder.imageView.setImageResource(0);
        }else if (status == 1){
            holder.btn.setText("已支付");
            holder.btn.setBackgroundColor(Color.GREEN);
            holder.imageView.setImageResource(R.drawable.over);
        }else{
            holder.btn.setText("已取消");
            holder.btn.setBackgroundColor(Color.GRAY);
            holder.imageView.setImageResource(0);
        }
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   onClickListener.Onclick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list!= null ? list.size():0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView time,price;
        private Button btn;
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            time=itemView.findViewById(R.id.indent_fragment_but_adapter_time);
            price=itemView.findViewById(R.id.indent_fragment_but_adapter_price);
            btn=itemView.findViewById(R.id.indent_fragment_but_adapter_btn);
            imageView=itemView.findViewById(R.id.indent_fragment_but_adapter_simple);
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

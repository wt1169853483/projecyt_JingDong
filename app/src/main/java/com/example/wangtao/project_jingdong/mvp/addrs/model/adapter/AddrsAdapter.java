package com.example.wangtao.project_jingdong.mvp.addrs.model.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsUserBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.adapter.RectcleMiaoshaAdapter;

import java.util.List;

/**
 * Created by wangtao on 2018/7/18.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class AddrsAdapter extends RecyclerView.Adapter<AddrsAdapter.MyViewHolder>{
   private   List<AddrsUserBean.DataBean> list;
  private Context context;


    public AddrsAdapter(List<AddrsUserBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.addrs_activity_adapters, parent, false);
        MyViewHolder myViewHolder=new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        int status = list.get(position).getStatus();
        if (status == 1){
            holder.checkBox.setChecked(true);
            holder.defaultTexr.setText("默认地址");
        }else{
        holder.checkBox.setChecked(false);
        holder.defaultTexr.setText("");
        }
        holder.userName.setText(list.get(position).getName()+"       "+list.get(position).getMobile());
        holder.addrText.setText("地址:"+list.get(position).getAddr());
        holder.bianjiText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  onClickListener.Onclick(position);
            }
        });
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  onClickListener.CheckBoxOnclick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list!= null ? list.size():0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView userName,addrText,defaultTexr;
        private CheckBox checkBox;
        LinearLayout bianjiText;
        public MyViewHolder(View itemView) {
            super(itemView);
            userName=itemView.findViewById(R.id.addrs_activity_adapter_username);
            addrText=itemView.findViewById(R.id.addrs_activity_adapter_addrs);
            bianjiText=itemView.findViewById(R.id.addrs_activity_adapter_bianji);
            defaultTexr=itemView.findViewById(R.id.addrs_activity_adapter_setDefault);
            checkBox=itemView.findViewById(R.id.addrs_activity_adapters_checkBox);

        }
    }
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface  OnClickListener{
        public void Onclick(int position);
        public void CheckBoxOnclick(int position);
    }

}

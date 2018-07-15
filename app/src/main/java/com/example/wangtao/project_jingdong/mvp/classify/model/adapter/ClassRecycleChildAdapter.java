package com.example.wangtao.project_jingdong.mvp.classify.model.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyRightBean;
import com.example.wangtao.project_jingdong.mvp.classify.view.activity.ClassRecycleActivity;
import com.example.wangtao.project_jingdong.mvp.homepage.model.adapter.RectcleMiaoshaAdapter;
import com.example.wangtao.project_jingdong.mvp.homepage.view.activity.HomeActivity;

import java.util.List;

/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class ClassRecycleChildAdapter extends RecyclerView.Adapter<ClassRecycleChildAdapter.MyViewHolder>{
    private List<ClassifyRightBean.DataBean> list;
    private Context context;

    public ClassRecycleChildAdapter(List<ClassifyRightBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.classify_fragment_right_group, parent, false);
        MyViewHolder myViewHolder=new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
           holder.textView.setText(list.get(position).getName());

        final List<ClassifyRightBean.DataBean.ListBean> list = this.list.get(position).getList();

        ClassRecycleAdapter classRecycleAdapter=new ClassRecycleAdapter(list);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,3);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        holder.recyclerView.setLayoutManager(gridLayoutManager);
        holder.recyclerView.setAdapter(classRecycleAdapter);
        classRecycleAdapter.setOnClickListener(new RectcleMiaoshaAdapter.OnClickListener() {
            @Override
            public void Onclick(int position) {
                int pscid = list.get(position).getPscid();
                Intent intent=new Intent(context, ClassRecycleActivity.class);
                intent.putExtra("position",pscid);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0:list.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder{
       private TextView textView;
       private RecyclerView recyclerView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView =itemView.findViewById(R.id.classfiy_fragment_right_group_name);
            recyclerView=itemView.findViewById(R.id.classfiy_fragment_right_group_recycles);
        }
    }

}

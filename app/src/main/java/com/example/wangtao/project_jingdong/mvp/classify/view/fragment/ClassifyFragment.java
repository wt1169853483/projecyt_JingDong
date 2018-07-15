package com.example.wangtao.project_jingdong.mvp.classify.view.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BaseFragment;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyLeftBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyRightBean;
import com.example.wangtao.project_jingdong.mvp.classify.presenter.ClassifyPresenter;
import com.example.wangtao.project_jingdong.mvp.classify.view.iview.IClassView;

import java.util.List;

/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class ClassifyFragment extends BaseFragment<ClassifyPresenter> implements IClassView {
    private static final String TAG = "ClassifyFragment";
    private ListView listView;

    @Override
    protected int protetedId() {
        return R.layout.classfiy_fragment;
    }
    @Override
    protected ClassifyPresenter proPresenter() {
        return new ClassifyPresenter(this);
    }
    @Override
    protected void initView(View view) {
         //获取组件
        listView = view.findViewById(R.id.classfiy_fragment_listView);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        presenter.getClassPresenter();
    }

   //请求数据成功
    @Override
    public void getClassSuccess(ClassifyLeftBean json) {
        Log.d(TAG, "getClassSuccess: "+"   getClassSuccess");
        final List<ClassifyLeftBean.DataBean> data = json.getData();
        final BaseListAdapter baseListAdapter=new BaseListAdapter(data);
        listView.setAdapter(baseListAdapter);

        final int cid = data.get(0).getCid();

        FragmentManager manager=getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment= new ClassifyRightFragment();
        transaction.replace(R.id.classfiy_fragment_frameLayout,fragment);
        Bundle build =new Bundle();
        // Log.d(TAG, "onItemClick:cod: ++++++++++++++++"+cid);
        build.putString("urls",cid+"");
        fragment.setArguments(build);
        transaction.commit();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                baseListAdapter.setPages(position);
                baseListAdapter.notifyDataSetChanged();
                final int cid = data.get(position).getCid();
                String name = data.get(position).getName();
                // Toast.makeText(getActivity(),name,Toast.LENGTH_LONG).show();
                FragmentManager manager=getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment fragment= new ClassifyRightFragment();
                transaction.replace(R.id.classfiy_fragment_frameLayout,fragment);
                Bundle build =new Bundle();
                // Log.d(TAG, "onItemClick:cod: ++++++++++++++++"+cid);
                build.putString("urls",cid+"");
                fragment.setArguments(build);
                transaction.commit();

            }
        });
    }

    @Override
    public void getClassError(String error) {

    }

    //第二次请求
    @Override
    public void getClassRightSuccess(ClassifyRightBean json) {

    }

    @Override
    public void getClassRightError(String error) {

    }


    public class BaseListAdapter extends BaseAdapter{
        private int pages;
        private List<ClassifyLeftBean.DataBean> list;

        public BaseListAdapter(List<ClassifyLeftBean.DataBean> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

              Viewholder viewholder =null;
              if(convertView == null){
                   viewholder=new Viewholder();
                   convertView =View.inflate(getContext(),R.layout.classify_fragmet_listview,null);
                   viewholder.textView=convertView.findViewById(R.id.classfiy_fragment_listView_text);
                   convertView.setTag(viewholder);
              }else{
                    viewholder = (Viewholder) convertView.getTag();
               }
               viewholder.textView.setText(list.get(position).getName());
              if (position == pages){
                     viewholder.textView.setBackgroundColor(Color.GRAY);

              }else{
                  viewholder.textView.setBackgroundColor(Color.WHITE);
              }
            return convertView;
        }
     class Viewholder{
             TextView textView;
     }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){

        }

    }


}

package com.example.wangtao.project_jingdong.mvp.shoppingcart.model.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wangtao.project_jingdong.R;
import com.example.wangtao.project_jingdong.base.BasePresenter;
import com.example.wangtao.project_jingdong.mvp.classify.view.fragment.ClassifyFragment;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.presenter.ShopingPresenter;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.view.fragment.MyAddStuds;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by wangtao on 2018/7/12.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class ShopingExpandAdapter extends BaseExpandableListAdapter {
    private List<ShopingBean.DataBean> data;
    private Context context;
    private ShopingPresenter presenter;
    private boolean allProductsSelected;
    private SharedPreferences sharedPreferences;
    private String uid;

    public ShopingExpandAdapter(List<ShopingBean.DataBean> data, Context context, ShopingPresenter presenter) {
        this.data = data;
        this.context = context;
        this.presenter = presenter;
    }

    @Override
    public int getGroupCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data.get(groupPosition).getList() != null ? data.get(groupPosition).getList().size() : 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewChild groupViewChild = null;
        if (convertView == null) {
            groupViewChild = new GroupViewChild();
            convertView = View.inflate(context, R.layout.shoping_fragment_expan_group, null);
            groupViewChild.textView = convertView.findViewById(R.id.shoping_fragment_expan_group_sellName);
            groupViewChild.checkBox = convertView.findViewById(R.id.shoping_fragment_expan_group_check);

            convertView.setTag(groupViewChild);
        } else {
            groupViewChild = (GroupViewChild) convertView.getTag();
        }
        groupViewChild.textView.setText(data.get(groupPosition).getSellerName());

        groupViewChild.checkBox.setChecked(isOnParamGourpSelledSelected(groupPosition));
        groupViewChild.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shopingListener != null) {
                    shopingListener.getListGroupParamChanged(groupPosition);
                }
            }
        });
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, final ViewGroup parent) {
        //获取数据库
        sharedPreferences = context.getSharedPreferences("name", Context.MODE_PRIVATE);
        uid = sharedPreferences.getString("uid", 71 + "");
        ChildViewChild childViewChild = null;
        if (convertView == null) {
            childViewChild = new ChildViewChild();
            convertView = View.inflate(context, R.layout.shoping_fragment_expan_child, null);
            childViewChild.SellName = convertView.findViewById(R.id.shoping_fragment_expan_chile_sellName);
            childViewChild.PriceText = convertView.findViewById(R.id.shoping_fragment_expan_chile_price);
            childViewChild.checkBox = convertView.findViewById(R.id.shoping_fragment_expan_child_check);
            childViewChild.simpleDraweeView = convertView.findViewById(R.id.shoping_fragment_expan_child_simple);
            childViewChild.myAddStuds = convertView.findViewById(R.id.shoping_fragment_expan_chile_MyAddStuds);
            childViewChild.linearLayout = convertView.findViewById(R.id.shoping_fragment_expan_child_layout);
            convertView.setTag(childViewChild);
        } else {
            childViewChild = (ChildViewChild) convertView.getTag();
        }
        childViewChild.SellName.setText(data.get(groupPosition).getList().get(childPosition).getTitle());
        childViewChild.PriceText.setText("￥" + data.get(groupPosition).getList().get(childPosition).getPrice() + "");
        String images = data.get(groupPosition).getList().get(childPosition).getImages();
        String[] split = images.split("\\|");
        Uri uri = Uri.parse(split[0]);
        childViewChild.simpleDraweeView.setImageURI(uri);
        childViewChild.checkBox.setChecked(data.get(groupPosition).getList().get(childPosition).getSelected() == 1);

        childViewChild.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shopingListener != null) {
                    shopingListener.getListchildParamChanged(groupPosition, childPosition);
                }
            }
        });

        childViewChild.myAddStuds.setNumber(data.get(groupPosition).getList().get(childPosition).getNum());
        childViewChild.myAddStuds.setonNumberBachListener(new MyAddStuds.OnNumberBachListener() {
            @Override
            public void getNumberSeuccess(int num) {
                if (shopingListener != null) {
                    shopingListener.getListchildNumberChanged(groupPosition, childPosition, num);
                }
            }
        });

        //点击删除
        childViewChild.linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(context)
                        .setTitle("提示:")
                        .setMessage("确定删除")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                presenter.getShopingDeletePresenter(uid + "", data.get(groupPosition).getList().get(childPosition).getPid() + "");
                                data.get(groupPosition).getList().remove(childPosition);
                                //presenter.getShopingUpdataPresenter(uid + "", data.get(groupPosition).getSellerid() + "", data.get(groupPosition).getList().get(childPosition).getPid() + "", data.get(groupPosition).getList().get(childPosition).getSelected() + "", 10 + "");
                            }
                        })
                        .create();
                alertDialog.show();
                return false;
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    public Boolean isOnParamGourpSelledSelected(int groupPoition) {
        List<ShopingBean.DataBean.ListBean> list = data.get(groupPoition).getList();
        for (ShopingBean.DataBean.ListBean listBean : list) {
            if (listBean.getSelected() == 0) {
                return false;
            }
        }
        return true;
    }

    public void changedGourpSelledSelected(int groupPoition, boolean b) {
        ShopingBean.DataBean dataBean = data.get(groupPoition);
        List<ShopingBean.DataBean.ListBean> list = dataBean.getList();
        for (int i = 0; i < list.size(); i++) {
            ShopingBean.DataBean.ListBean listBean = list.get(i);
            listBean.setSelected(b ? 1 : 0);
        }
    }

    public void changedChildSelected(int groupPoition, int childPoition) {
        ShopingBean.DataBean.ListBean listBean = data.get(groupPoition).getList().get(childPoition);
        listBean.setSelected(listBean.getSelected() == 1 ? 0 : 1);

       // presenter.getShopingUpdataPresenter(uid + "", data.get(groupPoition).getSellerid() + "", data.get(groupPoition).getList().get(childPoition).getPid() + "", (listBean.getSelected() == 1 ? 0 : 1)+"", 10 + "");
        //presenter.getShopingPresenter(uid);
    }

    public void changedChildSelectedNumber(int groupPoition, int childPoition, int number) {
        ShopingBean.DataBean.ListBean listBean = data.get(groupPoition).getList().get(childPoition);
        listBean.setNum(number);
    }

    //设置全选全不选
    public boolean isAllProductsSelected() {
        for (int i = 0; i < data.size(); i++) {
                List<ShopingBean.DataBean.ListBean> list = data.get(i).getList();
                for (int j = 0; j < list.size(); j++) {
                    ShopingBean.DataBean.ListBean listBean = list.get(j);
                    if (listBean.getSelected() == 0) {
                        return false;
                    }
                }
        }
        return true;
    }

    public int changedAllPrices() {
        int tatoPriceAll = 0;
        for (int i = 0; i < data.size(); i++) {
            List<ShopingBean.DataBean.ListBean> list = data.get(i).getList();
            for (int j = 0; j < list.size(); j++) {
                ShopingBean.DataBean.ListBean listBean = list.get(j);
                if (listBean.getSelected() == 1) {
                    tatoPriceAll += listBean.getNum() * listBean.getPrice();
                }
            }
        }
        return tatoPriceAll;
    }

    public int changedAllNumber() {
        int tatoNumberAll = 0;
        for (int i = 0; i < data.size(); i++) {
            List<ShopingBean.DataBean.ListBean> list = data.get(i).getList();
            for (int j = 0; j < list.size(); j++) {
                ShopingBean.DataBean.ListBean listBean = list.get(j);
                if (listBean.getSelected() == 1) {
                    tatoNumberAll += listBean.getNum();
                }
            }
        }
        return tatoNumberAll;
    }

    public void changeAllProductsStatus(boolean b) {
        for (int i = 0; i < data.size(); i++) {
            List<ShopingBean.DataBean.ListBean> list = data.get(i).getList();
            for (int j = 0; j < list.size(); j++) {
                ShopingBean.DataBean.ListBean listBean = list.get(j);
                listBean.setSelected(b ? 1 : 0);
            }
        }
    }
    //刷新线上的数据
    public void refreshSelectedAndTotalPriceAndTotalLinew(int groupPoition,Boolean bool) {
        ShopingBean.DataBean dataBean = data.get(groupPoition);
        String sellerid = dataBean.getSellerid();
       // Log.e("tag", "refreshSelectedAndTotalPriceAndTotalLinew: "+sellerid );
        List<ShopingBean.DataBean.ListBean> list = dataBean.getList();
        for (int i = 0; i <list.size() ; i++) {
            int pid = list.get(i).getPid();
            int num = list.get(i).getNum();
            presenter.getShopingUpdataPresenter(uid+"",sellerid,pid+"",(bool?1:0)+"",num+"");
        }
    }

    public void refreshSelectedAndTotalPriceAndTotalChildLinew(int groupPoition, int childPoition) {
        ShopingBean.DataBean dataBean = data.get(groupPoition);
        String sellerid = dataBean.getSellerid();
       // Log.e("tag", "refreshSelectedAndTotalPriceAndTotalLinew22222: "+sellerid );
        ShopingBean.DataBean.ListBean listBean = dataBean.getList().get(childPoition);
        int pid = listBean.getPid();
        int num = listBean.getNum();
        int selected = listBean.getSelected();
        presenter.getShopingUpdataPresenter(uid+"",sellerid,pid+"",selected+"",num+"");
    }

    public void refreshSelectedAndTotalPriceAndTotalNumberLinew(int groupPoition, int childPoition, int number) {
        ShopingBean.DataBean dataBean = data.get(groupPoition);
        String sellerid = dataBean.getSellerid();
        //Log.e("tag", "refreshSelectedAndTotalPriceAndTotalLinew:111111 "+sellerid );
        ShopingBean.DataBean.ListBean listBean = dataBean.getList().get(childPoition);
        int pid = listBean.getPid();
        int selected = listBean.getSelected();
        presenter.getShopingUpdataPresenter(uid+"",sellerid,pid+"",(selected==1?0:1)+"",number+"");

    }


    class GroupViewChild {
        CheckBox checkBox;
        TextView textView;
    }

    class ChildViewChild {
        CheckBox checkBox;
        TextView SellName, PriceText;
        SimpleDraweeView simpleDraweeView;
        MyAddStuds myAddStuds;
        LinearLayout linearLayout;
    }

    //接口回调
    private OnShopingListener shopingListener;

    public void setOnShopingListener(OnShopingListener onShopingListener) {
        this.shopingListener = onShopingListener;
    }

    public interface OnShopingListener {
        void getListGroupParamChanged(int groupPoition);

        void getListchildParamChanged(int groupPoition, int childPoition);

        void getListchildNumberChanged(int groupPoition, int childPoition, int number);
    }

}

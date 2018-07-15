package com.example.wangtao.project_jingdong.mvp.shoppingcart.view.fragment;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wangtao.project_jingdong.R;

import org.w3c.dom.Text;

/**
 * Created by wangtao on 2018/7/12.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class MyAddStuds extends LinearLayout{

    private TextView jiaView;
    private TextView jianView;
    private TextView numbetText;
   private int number=1;
    public MyAddStuds(Context context) {
        super(context);

    }

    public MyAddStuds(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view= View.inflate(context,R.layout.shoping_fragment_add,this);
        jiaView = view.findViewById(R.id.shoping_fragment_add_jia);
        jianView = view.findViewById(R.id.shoping_fragment_add_jian);
        numbetText = view.findViewById(R.id.shoping_fragment_add_number);

        jianView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number >0){
                    --number;
                    numbetText.setText(number+"");
                    if (onNumberBachListener != null){
                         onNumberBachListener.getNumberSeuccess(number);
                    }
                }else{
                    Toast.makeText(context,"不能再减啦",Toast.LENGTH_LONG).show();
                }
            }
        });
        jiaView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                    ++number;
                    numbetText.setText(number+"");
                if (onNumberBachListener != null){
                    onNumberBachListener.getNumberSeuccess(number);
                }
            }
        });
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        numbetText.setText(number+"");
    }

    //接口回调
    //接口回调
    private OnNumberBachListener onNumberBachListener;

    public void setonNumberBachListener(OnNumberBachListener onNumberBachListener){
        this.onNumberBachListener =onNumberBachListener;
    }

    public interface OnNumberBachListener{
        void getNumberSeuccess(int num);
    }
}

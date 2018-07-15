package com.example.wangtao.project_jingdong.mvp.homepage.view.iview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wangtao on 2018/7/15.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class MyFlowLayout extends ViewGroup{
    private int  paddingTop=30;
    public MyFlowLayout(Context context) {
        super(context);
    }

    public MyFlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyFlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
       measureChildren(widthMeasureSpec,heightMeasureSpec);

        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        int width = 0;//AT—MOST模式的宽
        int height = 0;//AT—MOST模式的高
        int lineWidth = 0;//行宽
        int lineHeight = 0;//行高
        int totalHeight = 0;//前面的行的行高的和****累加高度
        View childView;
        int childWidth = 0;//孩子的宽
        int childHeight = 0;//孩子对的高

        for (int i = 0; i <getChildCount() ; i++) {
                 childView =getChildAt(i);
                 //获取子布局的宽高
               childWidth =childView.getMeasuredWidth();
               childHeight =childView.getMeasuredHeight();

               if (childWidth+paddingTop >sizeWidth){
                     throw  new IllegalArgumentException("长度太长");
               }
               if (childWidth+lineWidth+paddingTop >sizeWidth){
                      //换行
                   width =sizeWidth;
                   totalHeight +=lineHeight;
                   lineHeight =childHeight;
                   lineWidth =childWidth;
               }else{
                    // 不换行
                   lineWidth+=childWidth+paddingTop;
                   lineHeight =Math.max(lineHeight,childHeight);
                   width=Math.max(lineWidth,width);
               }
               if (i == getChildCount()-1){
                     totalHeight +=lineHeight;
                     height=totalHeight;
               }
        }

        width =modeWidth == MeasureSpec.EXACTLY? sizeWidth:width;
        height=modeHeight == MeasureSpec.EXACTLY?sizeHeight:height;

        setMeasuredDimension(width,height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int lineWidth = 0;//行宽
        int lineHeight = 0;//行高
        int totalHeight = 0;//前面的行的行高的和****累加高度
        View childView;
        int childWidth = 0;//孩子的宽
        int childHeight = 0;//孩子对的高

        for (int i = 0; i <getChildCount() ; i++) {
            childView =getChildAt(i);
            //获取子布局的宽高
            childWidth =childView.getMeasuredWidth();
            childHeight =childView.getMeasuredHeight();

            if (childWidth+lineWidth+paddingTop >getMeasuredWidth()){
                totalHeight +=lineHeight;
                lineWidth=0;
                ChildViewLayout(childView,lineWidth,totalHeight,lineWidth+childWidth+paddingTop,childHeight+totalHeight);
                lineHeight =childHeight;
                lineWidth =childWidth;
            }else{
                // 不换行
                ChildViewLayout(childView,lineWidth,totalHeight,lineWidth+childWidth+paddingTop,childHeight+totalHeight);
                lineWidth+=childWidth;
                lineHeight =Math.max(lineHeight,childHeight);
            }
        }
    }

    private void ChildViewLayout(View childView, int lineWidth, int totalHeight, int i, int i1) {

            childView.layout(lineWidth,totalHeight,i,i1);
    }
}

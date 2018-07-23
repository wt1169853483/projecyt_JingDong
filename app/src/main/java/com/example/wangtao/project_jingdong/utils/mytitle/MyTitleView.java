package com.example.wangtao.project_jingdong.utils.mytitle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wangtao.project_jingdong.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Author JenSenLeung.
 * @Time 2018/7/11 下午 7:30.
 * @Description This is MyTitleView.
 */
public class MyTitleView extends LinearLayout {
    @BindView(R.id.btn_left)
    Button btnLeft;
    @BindView(R.id.et_search)
    TextView etSearch;
    @BindView(R.id.btn_right)
    Button btnRight;

    public MyTitleView(Context context) {
        super(context);
    }

    public MyTitleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @SuppressLint("ResourceAsColor")
    public MyTitleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyTitleView, 0, 0);
        String leftText = typedArray.getString(R.styleable.MyTitleView_left_text);
        int leftBackground = typedArray.getResourceId(R.styleable.MyTitleView_left_background, R.color.colorAccent);
        boolean leftVisibility = typedArray.getBoolean(R.styleable.MyTitleView_left_visibility, true);

        String searchText = typedArray.getString(R.styleable.MyTitleView_search_text);
        String searchHintText = typedArray.getString(R.styleable.MyTitleView_search_hint_text);
        int searchBackground = typedArray.getResourceId(R.styleable.MyTitleView_search_background, R.color.colorRed);
        boolean searchVisibility = typedArray.getBoolean(R.styleable.MyTitleView_search_visibility, true);


        String rightText = typedArray.getString(R.styleable.MyTitleView_right_text);
        int rightBackground = typedArray.getResourceId(R.styleable.MyTitleView_right_background, R.color.colorAccent);
        boolean rightVisibility = typedArray.getBoolean(R.styleable.MyTitleView_right_visibility, true);


        View view = inflate(context, R.layout.my_title_view, this);
        ButterKnife.bind(view);

        btnLeft.setText(leftText);
        btnLeft.setBackgroundResource(leftBackground);
        btnLeft.setVisibility(leftVisibility ? VISIBLE : INVISIBLE);

        etSearch.setHint(searchHintText);
        etSearch.setText(searchText);
        etSearch.setVisibility(searchVisibility ? VISIBLE : INVISIBLE);
        etSearch.setBackgroundResource(searchBackground);

        btnRight.setText(rightText);
        btnRight.setBackgroundResource(rightBackground);
        btnRight.setVisibility(rightVisibility ? VISIBLE : INVISIBLE);
    }

    @OnClick({R.id.btn_left, R.id.et_search, R.id.btn_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_left:
                if (onMyTitleViewClickListener != null) {
                    onMyTitleViewClickListener.leftClick();
                }
                break;
            case R.id.et_search:
                if (onMyTitleViewClickListener != null) {
                    onMyTitleViewClickListener.searchClick();
                }
                break;
            case R.id.btn_right:
                if (onMyTitleViewClickListener != null) {
                    onMyTitleViewClickListener.rightClick();
                }
                break;
        }
    }

    OnMyTitleViewClickListener onMyTitleViewClickListener;

    public void setOnMyTitleViewClickListener(OnMyTitleViewClickListener onMyTitleViewClickListener) {
        this.onMyTitleViewClickListener = onMyTitleViewClickListener;
    }

    public interface OnMyTitleViewClickListener {
        void leftClick();

        void searchClick();

        void rightClick();
    }
}

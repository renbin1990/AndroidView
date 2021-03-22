package com.xiaobin.androidview.weigth;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaobin.androidview.R;

/**
 * data:2021/3/17
 * Author:renbin
 */
public class TitleBar extends RelativeLayout {

    private ImageView iv_back;
    private TextView tv_title;
    private ImageView iv_right;
    private RelativeLayout rl_titlebar_layout;
    private int backgroundColor = Color.BLUE;
    private int textColorColor = Color.WHITE;
    private int underlineColor = Color.GRAY;
    private String titleName = "";
    private View underline_view;

    public TitleBar(Context context) {
        super(context);
        initView(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.TitleBar);
        backgroundColor = typedArray.getColor(R.styleable.TitleBar_title_bg,Color.BLUE);
        textColorColor = typedArray.getColor(R.styleable.TitleBar_title_text_color,Color.WHITE);
        titleName = typedArray.getString(R.styleable.TitleBar_title_text);
        underlineColor = typedArray.getColor(R.styleable.TitleBar_underline_bg,Color.GRAY);
        //释放资源
        typedArray.recycle();
        initView(context);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_titlebar,this,true);
        iv_back = findViewById(R.id.iv_back);
        tv_title = findViewById(R.id.tv_title);
        iv_right = findViewById(R.id.iv_right);
        rl_titlebar_layout = findViewById(R.id.rl_titlebar_layout);
        underline_view = findViewById(R.id.underline_view);
        rl_titlebar_layout.setBackgroundColor(backgroundColor);
        tv_title.setTextColor(textColorColor);
        tv_title.setText(titleName);
        underline_view.setBackgroundColor(underlineColor);
    }

    public void setTitle(String titleName){
        if (!TextUtils.isEmpty(titleName)){
            tv_title.setText(titleName);
        }
    }

    public void setLeftListener(OnClickListener onClickListener){
        iv_back.setOnClickListener(onClickListener);
    }

    public void setRightListener(OnClickListener onClickListener){
        iv_right.setOnClickListener(onClickListener);
    }
}

package com.xiaobin.androidview.weigth;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.xiaobin.androidview.R;

/**
 * data:2021/3/17
 * Author:renbin
 * 继承view自定义控件
 */
public class RectView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int color;

    public RectView(Context context) {
        super(context);
        initDraw();
    }

    public RectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //使用attrs配置文件，为RectView自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RectView);
        //提取RectView的rect_color属性，设置，如果没设置 则默认Color.RED属性
        color = typedArray.getColor(R.styleable.RectView_rect_color, Color.RED);
        //获取资源后回收
        typedArray.recycle();
        initDraw();
    }

    public RectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDraw();
    }

    private void initDraw() {
        paint.setColor(color);
        paint.setStrokeWidth(2.0f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置padding
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        //设置宽高
        int width = getWidth()-paddingLeft-paddingRight;
        int height = getHeight()-paddingTop-paddingBottom;
        canvas.drawRect(0+paddingLeft,0+paddingTop,width+paddingRight,height+paddingBottom,paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //设置默认宽高,设置wrap_content时生效,setMeasuredDimension单位是px
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(300,300);
        }else if (widthSpecMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(300,heightSpecSize);
        }else if (heightSpecMode ==  MeasureSpec.AT_MOST){
            setMeasuredDimension(widthSpecSize,300);
        }
    }
}

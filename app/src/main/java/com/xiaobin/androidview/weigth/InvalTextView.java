package com.xiaobin.androidview.weigth;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * data:2021/3/17
 * Author:renbin
 * 自定义textview
 */
public class InvalTextView extends AppCompatTextView {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public InvalTextView(Context context) {
        super(context);
        initDraw();
    }

    public InvalTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initDraw();
    }

    public InvalTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDraw();
    }

    private void initDraw() {
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5.5f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        //划横线
        canvas.drawLine(0,height/2,width,height/2,paint);
        //划竖线
        canvas.drawLine(width/2,0,width/2,height,paint);

        canvas.drawLine(0,height-2f,width,height-2f,paint);
    }
}

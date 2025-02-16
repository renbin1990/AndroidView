package com.xiaobin.androidview.weigth;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

import com.xiaobin.androidview.R;

import java.util.List;

/**
 *data:2021/5/17
 *Author:renbin
 * 带标签的textview
 */
public class TagTextView extends AppCompatTextView {

    private Drawable bg ;
    private int color ;
    private StringBuffer content_buffer;
    private TextView tv_tag;
    private View view;//标签布局的最外层布局
    private Context mContext;

//必须重写所有的构造器，否则可能会出现无法inflate布局的错误！
    public TagTextView(Context context) {
        super(context);
        mContext = context;
    }


    public TagTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        //使用attrs配置文件，为RectView自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RectView);
        //提取RectView的rect_color属性，设置，如果没设置 则默认Color.RED属性
        bg = typedArray.getDrawable(R.styleable.TagTextView_TagTextView_bg);
        color = typedArray.getColor(R.styleable.TagTextView_Tag_textcolor, Color.RED);
        if (tv_tag!= null){
            tv_tag.setBackgroundDrawable(bg);
            tv_tag.setTextColor(color);
        }
        //获取资源后回收
        typedArray.recycle();
    }


    public TagTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }


    public void setContentAndTag(String content, List<String> tags) {
        content_buffer = new StringBuffer();
        for (String item : tags) {//将每个tag的内容添加到content后边，之后将用drawable替代这些tag所占的位置
            content_buffer.append(item);
        }
        content_buffer.append(content);
        SpannableString spannableString = new SpannableString(content_buffer);
        for (int i = 0; i < tags.size(); i++) {
            String item = tags.get(i);
            View view = LayoutInflater.from(mContext).inflate(R.layout.tag, null);//R.layout.tag是每个标签的布局
            tv_tag = view.findViewById(R.id.tv_tag);
            tv_tag.setText(item);
            Bitmap bitmap = convertViewToBitmap(view);
            Drawable d = new BitmapDrawable(bitmap);
            d.setBounds(0, 0, tv_tag.getWidth(), tv_tag.getHeight());//缺少这句的话，不会报错，但是图片不回显示
            ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BOTTOM);//图片将对齐底部边线
            int startIndex;
            int endIndex;
            startIndex = getLastLength(tags, i );
            endIndex = startIndex + item.length();
            Log.e("tag", "the start is" + startIndex + "the end is" + endIndex);
            spannableString.setSpan(span, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        setText(spannableString);
        setGravity(Gravity.CENTER_VERTICAL);
    }


    private static Bitmap convertViewToBitmap(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }


    private int getLastLength(List<String> list, int maxLength) {
        int length = 0;
        for (int i = 0; i < maxLength; i++) {
            length += list.get(i).length();
        }
        return length;
    }
}
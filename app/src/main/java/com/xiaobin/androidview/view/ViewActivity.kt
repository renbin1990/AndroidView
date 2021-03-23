package com.xiaobin.androidview.view

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.toolbox.Volley.newRequestQueue
import com.xiaobin.androidview.R
import com.xiaobin.androidview.weigth.TitleBar
import com.xiaobin.androidview.weigth.VolleyNetUtils
import kotlinx.android.synthetic.main.activity_view.*

/**
 *Time:
 *Author:renbin
 */
class ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        initView();
        //自定义控件
        //1 继承系统控件的自定义View:这种自定义  View 在系统控件的基础上进行拓展，
       // 一般是添加新的功能或者修改显示的效果，一般情况 下在onDraw（）方法中进行处理
        //2 继承View 实现自定义控件 --- RectView
        //自定义view除了要实现onDraw,还要考虑到宽高以及外边距内边距的设置，对外提供自定义属性
        //3自定义属性，在values目录下创建  attrs.xml：
        //自定义组合控件 ：自定义组合控件就是多个控件组合起来 成为一个新的控件--自定义titleBar
        val  title = findViewById<TitleBar>(R.id.title)
        title.setLeftListener{
            finish()
        }

        title.setRightListener{
            Toast.makeText(this,"点击右侧按钮",Toast.LENGTH_LONG).show()
        }

        //4 自定义viewGroup
        //继承viewgroup,实现一些类似于viewpager的控件


        invalTextView.setOnClickListener {
            VolleyNetUtils.newRequestQueue("https://www.baidu.com",this)
        }
    }

    private fun initView() {
        //自定义控件平移
   //     customView.smoothScrollTo(-400,-200)
        view_translate.animation = AnimationUtils.loadAnimation(this,R.anim.translate)
    }
}
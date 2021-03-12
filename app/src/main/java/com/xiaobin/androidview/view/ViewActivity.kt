package com.xiaobin.androidview.view

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.xiaobin.androidview.R
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
    }

    private fun initView() {
        //自定义控件平移
        customView.smoothScrollTo(-400,-200)

        view_translate.animation = AnimationUtils.loadAnimation(this,R.anim.translate)
    }
}
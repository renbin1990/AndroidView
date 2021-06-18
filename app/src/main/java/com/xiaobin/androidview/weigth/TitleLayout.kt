package com.xiaobin.androidview.weigth

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import com.xiaobin.androidview.R

/**
 *data:2021/5/20
 *Author:renbin
 */
class TitleLayout(context: Context ,attrs :AttributeSet) : RelativeLayout(context,attrs) {

    init {
        val inflate = LayoutInflater.from(context).inflate(R.layout.view_titlebar, this)
        inflate.findViewById<ImageView>(R.id.iv_back).setOnClickListener {
            val activity = context as Activity
            activity.finish()
        }
    }
}
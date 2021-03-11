package com.xiaobin.androidview.inter

import android.view.View

/**
 *Time:20210311
 *Author:renbin
 */
interface OnClickListener {
    fun OnClick(view : View , position : Int)
    fun OnLongClick(view : View , position : Int)
}
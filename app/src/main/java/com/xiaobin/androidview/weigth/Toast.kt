package com.xiaobin.androidview.weigth

import android.content.Context
import android.widget.Toast
import com.xiaobin.androidview.app.MyApplication

/**
 *data:2021/6/9
 *Author:renbin
 */

fun String.showToast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(MyApplication.context, this, duration).show()
}
fun Int.showToast( duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(MyApplication.context, this, duration).show()
}
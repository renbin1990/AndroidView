package com.xiaobin.androidview.weigth

import android.content.SharedPreferences

/**
 *data:2021/5/28
 *Author:renbin
 */
fun SharedPreferences.open(block: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.block()
    editor.apply()
}
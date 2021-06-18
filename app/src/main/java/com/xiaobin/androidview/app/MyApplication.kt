package com.xiaobin.androidview.app

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 *data:2021/6/18
 *Author:renbin
 */
class MyApplication :Application() {

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context : Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}
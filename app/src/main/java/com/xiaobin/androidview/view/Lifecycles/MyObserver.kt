package com.xiaobin.androidview.view.Lifecycles

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import java.util.logging.Logger

/**
 *data:2021/6/15
 *Author:renbin
 */
class MyObserver() : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun activityStart(){
        Log.e("MyObserver", "activityStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun activityStop(){
        Log.e("MyObserver", "activityStop")
    }
}
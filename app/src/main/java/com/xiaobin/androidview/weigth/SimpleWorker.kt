package com.xiaobin.androidview.weigth

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 *data:2021/6/17
 *Author:renbin
 * (1) 定义一个后台任务，并实现具体的任务逻辑；
 * (2) 配置该后台任务的运行条件和约束信息，并构建后台任务请求；
(3) 将该后台任务请求传入WorkManager的enqueue()方法中，系统会在合适的时间运行。
 */
class SimpleWorker(context: Context,params:WorkerParameters) : Worker(context,params) {
    override fun doWork(): Result {
        Log.d("SimpleWorker", "do work in SimpleWorker")
        return Result.success()
    }
}
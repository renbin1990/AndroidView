package com.xiaobin.androidview.broadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 *data:2021/5/27
 *Author:renbin
 */
class MyBroadcastReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "received in MyBroadcastReceiver", Toast.LENGTH_SHORT).show()
       //就表示将这条广播截断，后面 的BroadcastReceiver将无法再接收到这条广播。
    //    abortBroadcast()
    }
}
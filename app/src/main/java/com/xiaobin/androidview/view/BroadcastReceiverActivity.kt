package com.xiaobin.androidview.view

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.xiaobin.androidview.R
import com.xiaobin.androidview.base.BaseActivity

/**
 *data:2021/5/27
 *Author:renbin
 * 广播
 */
class BroadcastReceiverActivity : BaseActivity() {
    lateinit var timeChangeReceiver: TimeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast)

        //TODO 接受系统广播
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.TIME_TICK")
        timeChangeReceiver =  TimeChangeReceiver()
        registerReceiver(timeChangeReceiver,intentFilter)

        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent("com.xiaobin.androidview.broadcastReceiver.broadcasttest.MY_BROADCAST")
            intent.setPackage(packageName)
            //发送广播
           // sendBroadcast(intent)
            //发送有序广播
            sendOrderedBroadcast(intent,null)
        }

        //强制下线逻辑
        findViewById<Button>(R.id.button1).setOnClickListener {
            val intent = Intent("com.example.broadcastbestpractice.FORCE_OFFLINE")
            intent.setPackage(packageName)
            sendBroadcast(intent)
        }
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }

  inner class TimeChangeReceiver : BroadcastReceiver() {
         override fun onReceive(context: Context?, intent: Intent?) {
             Toast.makeText(context, "Time has changed", Toast.LENGTH_SHORT).show()
             Log.e("----->  " , "Time has changed")
         }
     }
}
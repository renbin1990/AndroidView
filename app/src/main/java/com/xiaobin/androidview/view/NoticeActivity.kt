package com.xiaobin.androidview.view

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.xiaobin.androidview.R
import com.xiaobin.androidview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_notice.*

/**
 *data:2021/6/3
 *Author:renbin
 */
class NoticeActivity :BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice)
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        //如果是Android 8.0系统，需要构建消息通知渠道
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("normal", "Normal",NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)         }
        btn_send_notice.setOnClickListener {
            val notification = NotificationCompat.Builder(this, "normal")
                .setContentTitle("This is content title")
                .setContentText("This is content text")
                .setSmallIcon(R.drawable.icon_zhuanti)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.icon_zhuanti))
                .build()
            notificationManager.notify(1, notification)
        }
    }
}
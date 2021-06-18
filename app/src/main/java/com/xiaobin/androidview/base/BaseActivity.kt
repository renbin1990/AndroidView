package com.xiaobin.androidview.base

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.xiaobin.androidview.manager.ActivityCollector
import com.xiaobin.androidview.view.MainActivity
import com.xiaobin.androidview.view.ViewActivity
import com.xiaobin.androidview.view.news.NewsContentActivity

/**
 *data:2021/5/19
 *Author:renbin
 */
open class BaseActivity : AppCompatActivity() {
    lateinit var receiver: ForceOfflineReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollector.addActivity(this)
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.example.broadcastbestpractice.FORCE_OFFLINE")
        receiver = ForceOfflineReceiver()
        registerReceiver(receiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    inner class ForceOfflineReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Toast.makeText(context,
                "You are forced to be offline. Please try to login again.",
                Toast.LENGTH_SHORT).show()
            AlertDialog.Builder(context).apply {
                setTitle("Warning")
                setMessage("You are forced to be offline. Please try to login again.")
                setCancelable(false)
                setPositiveButton("OK") { _, _ ->
                    ActivityCollector.finishAll() // 销毁所有Activity
                    val i = Intent(context, MainActivity::class.java)
                    context.startActivity(i) // 重新启动LoginActivity                 }
                }
            }.show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    //TODO companion object
    companion object {
        fun gotoViewActivity(context: Context, data: String) {
            val intent = Intent(context, ViewActivity::class.java)
            intent.putExtra("data", data)
            context.startActivity(intent)
        }

        fun gotoNewsContentActivity(context: Context, title: String, content: String) {
            val intent = Intent(context, NewsContentActivity::class.java).apply {
                putExtra("news_title", title)
                putExtra("news_content", content)
            }
            context.startActivity(intent)
        }

        inline fun <reified T> startActivity(context: Context) {
            val intent = Intent(context, T::class.java)
            context.startActivity(intent)
        }

        inline fun <reified T> startActivity(context: Context, block: Intent.() -> Unit) {
            val intent = Intent(context, T::class.java)
            intent.block()
            context.startActivity(intent)
        }
    }
}
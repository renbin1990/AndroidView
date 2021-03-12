package com.xiaobin.androidview.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.xiaobin.androidview.R
import kotlinx.android.synthetic.main.activity_view.*

/**
 *Time:
 *Author:renbin
 */
class ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        initView();
    }

    private fun initView() {
        view_translate.setOnClickListener {
    //        view_translate.animation =
        }
    }
}
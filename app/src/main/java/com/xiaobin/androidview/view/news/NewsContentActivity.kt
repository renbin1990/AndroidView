package com.xiaobin.androidview.view.news

import android.os.Bundle
import com.xiaobin.androidview.R
import com.xiaobin.androidview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_news_content.*

/**
 *data:2021/5/26
 *Author:renbin
 */
class NewsContentActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_content)

        val title = intent.getStringExtra("news_title") // 获取传入的新闻标题
        val content = intent.getStringExtra("news_content") // 获取传入的新闻内容
        if (title != null && content != null) {
            val fragment = newsContentFrag as NewsContentFragment
            fragment.refresh(title, content) //刷新NewsContentFragment界面
        }
    }
}
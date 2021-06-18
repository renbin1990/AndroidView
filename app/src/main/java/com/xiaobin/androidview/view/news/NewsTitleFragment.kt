package com.xiaobin.androidview.view.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xiaobin.androidview.R
import com.xiaobin.androidview.base.BaseActivity
import com.xiaobin.androidview.bean.NewS
import kotlinx.android.synthetic.main.activity_news_content.*
import kotlinx.android.synthetic.main.news_title_frag.*

/**
 *data:2021/5/26
 *Author:renbin
 */
class NewsTitleFragment : Fragment() {
    private var isTwoPane = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_title_frag, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isTwoPane = activity?.findViewById<View>(R.id.newsContentLayout)!= null
        val linearLayoutManager = LinearLayoutManager(activity)
        newsTitleRecyclerView.layoutManager = linearLayoutManager
        val newsAdapter = NewsAdapter(getNews())
        newsTitleRecyclerView.adapter = newsAdapter
    }

    private fun getNews(): List<NewS> {
        val newsList = ArrayList<NewS>()
        for (i in 1..50) {
        val news = NewS("This is news title $i", getRandomLengthString("This is news  content $i. "))
        newsList.add(news)
        }
        return newsList
    }
    private fun getRandomLengthString(str: String): String {
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(str)
        }
        return builder.toString()
    }

 inner  class NewsAdapter(val newsList: List<NewS>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val newsTitle: TextView = view.findViewById(R.id.newsTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)

            val holder = ViewHolder(view)
            holder.itemView.setOnClickListener {
                val news = newsList[holder.adapterPosition]
                if (isTwoPane) {
                    // 如果是双页模式，则刷新NewsContentFragment中的内容
                    val fragment = newsContentFrag as NewsContentFragment
                    fragment.refresh(news.title, news.content)
                } else {
                    // 如果是单页模式，则直接启动NewsContentActivity
                    BaseActivity.gotoNewsContentActivity(parent.context, news.title,
                        news.content)
                }
            }
            return holder
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val news = newsList[position]
            holder.newsTitle.text = news.title
        }
        override fun getItemCount(): Int = newsList.size
    }
}
package com.xiaobin.androidview.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.xiaobin.androidview.R
import com.xiaobin.androidview.adapter.MainAdapter
import com.xiaobin.androidview.base.BaseActivity
import com.xiaobin.androidview.view.news.NewsContentActivity
import com.xiaobin.androidview.weigth.showSnackbar
import com.xiaobin.androidview.weigth.showToast
import kotlinx.android.synthetic.main.activity_main.*

private val MainActivity.mainAdapter: MainAdapter
    get() {
        val recyclerViewAdapter = MainAdapter(this, data)
        return recyclerViewAdapter
    }

class MainActivity : BaseActivity() {
    val data = ArrayList<String>()
    private lateinit var recyclerViewAdapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initView()
    }

    private val mainAdapter1: MainAdapter
        get() {
            val recyclerViewAdapter =
                MainAdapter(this, data)
            return recyclerViewAdapter
        }

    private fun initView() {
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager
        if (!::recyclerViewAdapter.isInitialized) {
            recyclerViewAdapter = MainAdapter(this, data)
        }
        recyclerView.adapter = recyclerViewAdapter

        recyclerViewAdapter?.setOnClickListener {
            OnClickFun { view, position ->
                when (position) {
                    0 -> startActivity(Intent(this@MainActivity, RecyclerViewActivity::class.java))
                    1 -> gotoViewActivity(this@MainActivity, "ViewActivity")
                    2 -> startActivity(Intent(this@MainActivity, AnimatorActivity::class.java))
               //     3 -> gotoNewsContentActivity(this@MainActivity, "新闻", "新闻内容")
                    3 -> startActivity<NewsContentActivity>(this@MainActivity){
                        putExtra("news_title", "新闻")
                        putExtra("news_content", "新闻内容")
                    }

                    4 -> startActivity(Intent(this@MainActivity,
                        BroadcastReceiverActivity::class.java))
                    5 -> startActivity(Intent(this@MainActivity,
                        ReadContactsActivity::class.java))
//                    6 -> startActivity(Intent(this@MainActivity,
//                        NoticeActivity::class.java))
                //    6 -> startActivity<NoticeActivity>(this@MainActivity)
            //        6 ->   "哈哈哈".showToast(this@MainActivity)
                    6 ->   view.showSnackbar("showSnackbar","跳转"){
                        "通知".showToast(Toast.LENGTH_LONG)
                        startActivity<NoticeActivity>(this@MainActivity)
                    }
                    7-> startActivity<JetpackActivity>(this@MainActivity)
                }
            }

            OnLongClickFun { view, position ->
                Toast.makeText(this@MainActivity, data.get(position), Toast.LENGTH_SHORT).show()
            }
        }

        val listOf = mutableListOf<String>(" ")
 //       tagTextView.setContentAndTag("赵东是个大帅逼,赵东是个个大帅逼赵东是个大帅逼赵东是个大帅逼", listOf);
    }

    private fun initData() {
        data.add("RecyclerView")
        data.add("View Event")
        data.add("Animator")
        data.add("Fragment")
        data.add("BroadcastReceiver")
        data.add("readContacts")
        data.add("notice")
        data.add("Jetpack")
    }
}
package com.xiaobin.androidview.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.xiaobin.androidview.R
import com.xiaobin.androidview.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val data = ArrayList<String>()
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
        val recyclerViewAdapter =
            MainAdapter(this, data)
        recyclerView.adapter = recyclerViewAdapter

        recyclerViewAdapter?.setOnClickListener {
            OnClickFun { view, position ->
                when(position){
                   0 -> startActivity(Intent(this@MainActivity, RecyclerViewActivity::class.java))
                   1 -> startActivity(Intent(this@MainActivity, ViewActivity::class.java))
                   2 -> startActivity(Intent(this@MainActivity, AnimatorActivity::class.java))
                }
            }

            OnLongClickFun { view, position ->
                Toast.makeText(this@MainActivity, data.get(position), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initData() {
        data.add("RecyclerView")
        data.add("View Event")
        data.add("Animator")
    }
}
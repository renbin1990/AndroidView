package com.xiaobin.androidview.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.xiaobin.androidview.R
import com.xiaobin.androidview.adapter.RecyclerViewAdapter
import com.xiaobin.androidview.base.BaseActivity
import com.xiaobin.androidview.bean.Fruit
import kotlinx.android.synthetic.main.activity_recyclier.*

/**
 *Time:20210311
 *Author:renbin
 */
class RecyclerViewActivity : BaseActivity() {
    var data = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclier)

        initData();
        initView();
    }

    private fun initView() {
        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = manager
        val recyclerViewAdapter = RecyclerViewAdapter(this, data)
        recyclerView.adapter = recyclerViewAdapter

        tv1.setOnClickListener {
            val manager = LinearLayoutManager(this)
            manager.orientation = LinearLayoutManager.VERTICAL
            recyclerView.layoutManager = manager
            recyclerView.adapter = recyclerViewAdapter;
        }

        tv2.setOnClickListener {
            val manager = GridLayoutManager(this,4)
            recyclerView.layoutManager = manager
            recyclerView.adapter = recyclerViewAdapter;
        }

        tv3.setOnClickListener {
            val manager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
            recyclerView.layoutManager = manager
            recyclerView.adapter = recyclerViewAdapter;
        }

        recyclerViewAdapter.setOnClickListener {
            OnClickFun(){ view, position ->
                Toast.makeText(this@RecyclerViewActivity, "名字： "+data.get(position).name+" 价格： "+data.get(position).price, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initData() {
        data.add(Fruit("apple", 1248.0))
        data.add(Fruit("banana", 1231.31))
        data.add(Fruit("orange", 1342.1))
        data.add(Fruit("wate12312rmelon",12312.5241))
        data.add(Fruit("pear", 12312.5241))
        data.add(Fruit("grape", 12312.5241))
        data.add(Fruit("pin123eapple", 12312.5241))
        data.add(Fruit("strawberry", 12312.5241))
        data.add(Fruit("cherry", 12312.5241))
        data.add(Fruit("mango", 12312.5241))
        data.add(Fruit("apple", 1248.0))
        data.add(Fruit("basfsdfsdfsdnana", 1231.31))
        data.add(Fruit("orange", 1342.1))
        data.add(Fruit("watesdfsdrmelon",12312.5241))
        data.add(Fruit("pear", 12312.5241))
        data.add(Fruit("grape", 12312.5241))
        data.add(Fruit("pineapple", 12312.5241))
        data.add(Fruit("strawberry", 12312.5241))
        data.add(Fruit("cherry", 12312.5241))
        data.add(Fruit("mango", 12312.5241))
        data.add(Fruit("applesedfsdfsd", 1248.0))
        data.add(Fruit("bananasdfsdfsdfsd", 1231.31))
        data.add(Fruit("orangesdfsdfsdf", 1342.1))
        data.add(Fruit("watermelonsdfdsfsd",12312.5241))
        data.add(Fruit("peasdfsdfsdr", 12312.5241))
        data.add(Fruit("grsdfsdfape", 12312.5241))
        data.add(Fruit("pineapple", 12312.5241))
        data.add(Fruit("strawberry", 12312.5241))
        data.add(Fruit("cherry", 12312.5241))
        data.add(Fruit("mango", 12312.5241))
        data.add(Fruit("apple", 1248.0))
        data.add(Fruit("banana", 1231.31))
        data.add(Fruit("orange", 1342.1))
        data.add(Fruit("wate12312rmelon",12312.5241))
        data.add(Fruit("pear", 12312.5241))
        data.add(Fruit("grape", 12312.5241))
        data.add(Fruit("pin123eapple", 12312.5241))
        data.add(Fruit("strawberry", 12312.5241))
        data.add(Fruit("cherry", 12312.5241))
        data.add(Fruit("mango", 12312.5241))
        data.add(Fruit("apple", 1248.0))
        data.add(Fruit("basfsdfsdfsdnana", 1231.31))
        data.add(Fruit("orange", 1342.1))
        data.add(Fruit("watesdfsdrmelon",12312.5241))
        data.add(Fruit("pear", 12312.5241))
        data.add(Fruit("grape", 12312.5241))
        data.add(Fruit("pineapple", 12312.5241))
        data.add(Fruit("strawberry", 12312.5241))
        data.add(Fruit("cherry", 12312.5241))
        data.add(Fruit("mango", 12312.5241))
        data.add(Fruit("applesedfsdfsd", 1248.0))
        data.add(Fruit("bananasdfsdfsdfsd", 1231.31))
        data.add(Fruit("orangesdfsdfsdf", 1342.1))
        data.add(Fruit("watermelonsdfdsfsd",12312.5241))
        data.add(Fruit("peasdfsdfsdr", 12312.5241))
        data.add(Fruit("grsdfsdfape", 12312.5241))
        data.add(Fruit("pineapple", 12312.5241))
        data.add(Fruit("strawberry", 12312.5241))
        data.add(Fruit("cherry", 12312.5241))
        data.add(Fruit("mango", 12312.5241))
    }
}
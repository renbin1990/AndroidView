package com.xiaobin.androidview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xiaobin.androidview.R
import com.xiaobin.androidview.inter.OnClickListener
import java.util.ArrayList

class MainAdapter(val context: Context, var data: ArrayList<String>) :
    RecyclerView.Adapter<MainAdapter.viewHolder>() {

    private lateinit var listener: OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recyclier_main,parent,false)
        val viewHolder = viewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.textView.setText(data[position])

        holder.textView.setOnClickListener {
            listener.OnClick(holder.textView,position)
        }

        holder.textView.setOnLongClickListener {
            listener.OnLongClick(holder.textView,position)
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int = data.size

    //内部类 继承
    inner class viewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textView: TextView = v.findViewById(R.id.textView)
    }


    fun setOnClickListener(listener: Builder.() -> Unit) {
        val builder =
            Builder()
        builder.listener()
        this.listener = builder
    }

    /**
     * 定义个Builder,简化回调接口
     */
    class Builder : OnClickListener {

        // 定义一个函数变量
        private lateinit var onClickVal: (view : View , position : Int) -> Unit

        // 给函数变量赋值
        fun OnClickFun(listener: (view : View , position : Int) -> Unit) {
            this.onClickVal = listener
        }

        // 回调方法
        override fun OnClick(view : View , position : Int) {
            onClickVal.invoke(view,position)
        }

        //  定义一个函数变量
        private lateinit var onLongClickVal: (view : View , position : Int) -> Unit

        // 给函数变量赋值
        fun OnLongClickFun(listener: (view : View , position : Int) -> Unit) {
            this.onLongClickVal = listener
        }

        // 回调方法
        override fun OnLongClick(view : View , position : Int) {
            onLongClickVal.invoke(view, position)
        }
    }
}

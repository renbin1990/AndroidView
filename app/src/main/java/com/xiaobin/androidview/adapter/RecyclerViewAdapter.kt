package com.xiaobin.androidview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xiaobin.androidview.R
import com.xiaobin.androidview.bean.Fruit
import com.xiaobin.androidview.inter.OnClickListener

class RecyclerViewAdapter(val context : Context ,val data: ArrayList<Fruit>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private lateinit var listener: OnClickListener
    //内部类 继承
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tv_name: TextView = v.findViewById(R.id.tv_name)
        val tv_price: TextView = v.findViewById(R.id.tv_price)
        val ll_item: LinearLayout = v.findViewById(R.id.ll_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recyclier,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_name.setText(data.get(position).name)
        holder.tv_price.setText(""+(data.get(position).price))

        holder.ll_item.setOnClickListener {
            listener.OnClick(holder.ll_item,position)
        }
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

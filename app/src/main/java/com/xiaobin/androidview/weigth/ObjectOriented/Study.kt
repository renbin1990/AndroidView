package com.xiaobin.androidview.weigth.ObjectOriented

/**
 *data:2021/5/14
 *Author:renbin
 */
interface Study {
    fun readBook()
    fun doHomework(){
        /**
         * 添加默认输出函数，这样实现可以默认不实现，就可以调用打印默认值
         */
        println("do homework default implementation.")
    }
}
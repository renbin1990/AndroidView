package com.xiaobin.androidview.weigth

/**
 * 泛型
 */
class MyClass<T> {
    fun method(param: T): T {
        return param
    }

    /**'
     * 泛型方法
     */
    fun <T> methods(param: T): T {
        return param
    }

    /**
     * 设置为Number类型的泛型方法
     */
    fun <T : Number> method(param: T): T {
        return param
    }
}
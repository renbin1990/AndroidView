package com.xiaobin.androidview.weigth.singletonMode.DCL

/**
 *data:2021/3/30
 *Author:renbin
 * 双重检查模式-DCL
 */
class SingletonDclKotlin private constructor(){
    companion object{
        val instances : SingletonDclKotlin by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SingletonDclKotlin()
        }
    }
}
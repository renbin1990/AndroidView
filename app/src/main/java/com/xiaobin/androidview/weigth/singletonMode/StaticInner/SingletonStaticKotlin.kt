package com.xiaobin.androidview.weigth.singletonMode.StaticInner

/**
 *data:2021/3/30
 *Author:renbin
 */
class SingletonStaticKotlin private constructor(){
    companion object{
        val  instance = SingletonStaticKotlinHolder.holder
    }

    private object SingletonStaticKotlinHolder{
        val holder = SingletonStaticKotlin()
    }
}
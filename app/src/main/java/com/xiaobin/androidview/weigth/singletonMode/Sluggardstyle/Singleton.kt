package com.xiaobin.androidview.weigth.singletonMode.Sluggardstyle

/**
 *data:2021/3/30
 *Author:renbin
 */
class Singleton private constructor(){
    companion object{
        private var instence : Singleton ?= null
        get() {
            if (field == null){
                field = Singleton()
            }
            return field
        }

        fun get() : Singleton{
            return instence!!
        }
    }
}
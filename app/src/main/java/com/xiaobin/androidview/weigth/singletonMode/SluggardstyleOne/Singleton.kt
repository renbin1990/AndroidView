package com.xiaobin.androidview.weigth.singletonMode.Sluggardstyle

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

/**
 *data:2021/3/30
 *Author:renbin
 */
class SingletonKotlin private constructor() {
    companion object{
        private var instence : SingletonKotlin ?= null
        get() {
            if (field == null){
                field = SingletonKotlin()
            }
            return field
        }

        @Synchronized
        fun get() : SingletonKotlin{
            return instence!!
        }
    }
}
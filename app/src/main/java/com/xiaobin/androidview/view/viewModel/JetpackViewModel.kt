package com.xiaobin.androidview.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *data:2021/6/15
 *Author:renbin
 */
class JetpackViewModel(countReserved : Int) : ViewModel() {
    var counter = MutableLiveData<Int>()

    init {
        counter.value = countReserved
    }

    fun plusOne() {
        val count = counter.value ?: 0
        counter.value = count + 1
    }
    fun clear() {
        counter.value = 0
    }
}
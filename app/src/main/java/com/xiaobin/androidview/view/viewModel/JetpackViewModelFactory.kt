package com.xiaobin.androidview.view.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 *data:2021/6/15
 *Author:renbin
 */
class JetpackViewModelFactory(private val countReserved: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return JetpackViewModel(countReserved) as T
    }
}
package com.xiaobin.androidview.weigth

/**
 *data:2021/5/27
 *Author:renbin
 */
class Money(val  value : Int) {

    operator fun plus (money: Money):Money{
        val  sum = value + money.value
        return Money(sum)
    }

    operator fun plus (newValuse : Int) : Money{
        val  sum = value + newValuse
        return Money(sum)
    }
}
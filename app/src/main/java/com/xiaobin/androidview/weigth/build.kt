package com.xiaobin.androidview.weigth

/**
 *data:2021/5/31
 *Author:renbin
 */

fun <T> T.build(block: T.() -> Unit): T {     block()
    return this
}
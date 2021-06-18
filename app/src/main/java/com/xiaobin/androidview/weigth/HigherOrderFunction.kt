package com.xiaobin.androidview.weigth

/**
 *data:2021/5/27
 *Author:renbin
 */
class HigherOrderFunction {

  inline  fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
        val result = operation(num1, num2)
        return result
    }
}
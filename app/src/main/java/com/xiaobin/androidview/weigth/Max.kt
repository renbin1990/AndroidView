package com.xiaobin.androidview.weigth

/**
 *data:2021/6/9
 *Author:renbin
 */
fun max(vararg nums:Int) : Int{
    var maxNum = Int.MIN_VALUE
    for (num in nums){
        maxNum = kotlin.math.max(num,maxNum)
    }
    return maxNum
}

fun <T :Comparable<T>> maxs(vararg nums:T) :T{
    if (nums.isEmpty()) throw RuntimeException("Params can not be empty.")
    var maxNum = nums[0]
    for (num in nums){
        if (num > maxNum){
            maxNum = num
        }
    }
    return maxNum
}
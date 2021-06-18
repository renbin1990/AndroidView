package com.xiaobin.androidview.weigth

/**
 *data:2021/5/14
 *Author:renbin
 */
class KotlinBase {

}

fun main() {
    System.out.println("12312312312")
    System.out.println("答案" + largerNumber(2, 5))
    System.out.println("分数：" + getStore("Tom"))
    System.out.println("分数：" + getStores("Jim"))
    System.out.println("分数：" + getStores("TomOy"))
    checkNum(100L);
    //TODO 数字区间
    val range = 0..10
    for (num in range){
        print("$num  ")
    }
    println()
    //TODO 左闭右开区间,包头部不包尾
    val range1 = 0 until 10
    for (num in range1){
        print("$num  ")
    }
    println()
    //TODO 区间范围内递增2 相当于 for-i循环中i = i + 2的效果，step关键字，跳转
    for (num in range1 step 2){
        print("$num  ")
    }
    println()
    //TODO 倒叙打印数据到2，downTo关键字，倒叙输出
    for (num in 10 downTo  2){
        print("$num  ")
    }

}

/**
 * 数据类型匹配
 */
fun checkNum(number: Number) = when (number) {
    is Int -> println("$number is Int")
    is Long -> println("$number is Long")
    is Double -> println("$number is Double")
    else -> println("$number is not support")
}

/**
 * 参数对比
 */
fun getStore(name: String) = when (name) {
    "Tom" -> 87
    "Jim" -> 871
    "Jack" -> 827
    "Lily" -> 847
    else -> 0
}

fun getStores(name: String) = when{
    name.startsWith("Tom")  -> 87
    name=="Jim" -> 871
    name=="Jack" -> 827
    name=="Lily" -> 847
    else -> 0
}

/**
 * 运算，简单比较大小
 */
fun largerNumber(num1: Int, num2: Int) = if (num1 > num2) num1 else num2
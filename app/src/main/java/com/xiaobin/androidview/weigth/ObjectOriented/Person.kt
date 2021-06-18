package com.xiaobin.androidview.weigth.ObjectOriented

/**
 *data:2021/5/14
 *Author:renbin
 */
open  class Person(val name :String ,val age : Int) {
    fun eat() = when{
        name == "renbin" -> println( "$name is boy ,He is $age years old .")
        name == "xiuxiu" -> println( "$name is girl ,He is $age years old .")
        else -> println( "$name is eating ,He is $age years old .")
    }
}
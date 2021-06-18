package com.xiaobin.androidview.weigth

import android.content.Context
import android.provider.Settings.Global.putString
import com.xiaobin.androidview.weigth.ObjectOriented.Study
import com.xiaobin.androidview.weigth.StringUtils.lettersCounts
import kotlinx.coroutines.*
import java.lang.StringBuilder
import kotlin.coroutines.EmptyCoroutineContext.plus

/**
 *data:2021/5/19
 *Author:renbin
 * 函数测试
 */
fun main() {
    //TODO let函数 处理全局变量的判空问题的
    doStudyse(null)

    //TODO with函数
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = with(StringBuilder()) {
        append("start eating fruits  :")
        for (fruit in list) {
            append("$fruit  ")
        }
        append(",Ate all fruits.")
        toString()
    }
    println(result)

    //TODO run函数
    val result1 = StringBuilder().run {
        append("start eating fruits  :")
        for (fruit in list) {
            append("$fruit  ")
        }
        append(",Ate all fruits.")
        toString()
    }
    println(result1)

    //TODO apply函数
    val result2 = StringBuilder().apply {
        append("start eating fruits  :")
        for (fruit in list) {
            append("$fruit  ")
        }
        append(",Ate all fruits.")
    }
    println(result2)

    //TODO 静态方法
    Helper.doAction()
    doActions()

    //TODO as关键字  强制类型转换
    //TODO lateinit关键字  延迟初始化使用的是lateinit关键字，它可以告诉Kotlin编译器，我
    // 会在晚些时候对这个变量 进行初始化，这样就不用在一开始的时候将它赋值为null了

    //TODO 密封类的关键字是sealed class
    getgetResultMsg(result = Success("1231"))

    val str = "ABC123xyz!@#"
    val count = StringUtils.lettersCount(str)
    println(count)
    println(str.lettersCounts())

    val money1 = Money(5)
    val money2 = Money(10)
    val money3 = money1 + money2
    println(money3.value + 20)
    //TODO 高阶函数
    val higherOrderFunction = HigherOrderFunction()
    println(higherOrderFunction.num1AndNum2(1, 2) { n1, n2 -> n1 + n2 })
    println(higherOrderFunction.num1AndNum2(1, 2) { n1, n2 -> n1 - n2 })

    //TODO 内联函数  inline
    println(1 + 2)
    // TODO 协程
    GlobalScope.launch {
        println("codes run in coroutine scope")
        delay(1500)
        println("codes run in coroutine scope finished")
    }

    runBlocking {
        launch {
            println("launch1")
            delay(1000)
            println("launch1 finished")
        }

        launch {
            println("launch2")
            delay(1000)
            println("launch2 finished")
        }
    }

//    val start = System.currentTimeMillis()
//    runBlocking {
//        repeat(100000) {
//            launch {
//                println(".")
//            }
//        }
//    }
//    val end = System.currentTimeMillis()
//    println(end - start)

    runBlocking {
        coroutineScope {
            launch {
                for (i in 1..10) {
                    println(i)
                    delay(1000)
                }
            }
        }
        println("coroutineScope finished")
    }
    println("runBlocking finished")

    //协程常用的写法
    val job = Job()
    val scope = CoroutineScope(job)
    scope.launch {

    }
    job.cancel()

    //计算  TODO vararg关键字 可以接受任意多个相同类型的参数
    println(max(1,2))
    println(max(1,2,3,4))
    println(maxs(1.0,2.0,3.0,4.0))
}

fun doStudyse(study: Study?) {
    study?.let {
        study.readBook()
        study.doHomework()
    }
}

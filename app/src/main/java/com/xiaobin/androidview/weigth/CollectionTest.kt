package com.xiaobin.androidview.weigth

import com.xiaobin.androidview.weigth.ObjectOriented.Study

/**
 *data:2021/5/17
 *Author:renbin
 */
class CollectionTest {

}
fun main() {
    //TODO list集合传统
    val list = ArrayList<String>()
    list.add("Apple")
    list.add("Banana")
    //固定长度的集合
    val list1 = listOf<String>("Apple", "Banana", "Orange", "Pear", "Grape")
    for (item in list1){
        print("$item    ")
    }
    println("")
    //可变的集合
    val mutableListOf = mutableListOf<String>("Apple", "Banana", "Orange", "Pear")
    mutableListOf.add("Grape")
    mutableListOf.add("草莓")
    for (item in mutableListOf){
        print("$item    ")
    }
    println("")
    //TODO map集合  传统
    val map = HashMap<String, Int>()
    map.put("Apple", 1)
    map.put("Banana", 2)
    map.put("Orange", 3)
    map.put("Pear", 4)
    map.put("Grape", 5)

    val hashMapOf = hashMapOf<String, Int>("Apple" to 1, "Banana" to 2, "Orange" to 3, "Pear" to 4, "Grape" to 5)
    hashMapOf.put("Apple1", 6)
    for ((fruit, number) in hashMapOf) {
        println("fruit is " + fruit + ", number is " + number)
    }
    //TODO 集合API
    //找出长度最大的水果
    val maxByFruit = mutableListOf.maxBy { it.length }
    println("max length fruit is $maxByFruit")
    //全部大写
    val map1 = mutableListOf.map { it.toUpperCase() }
    for (item in map1){
        print("$item    ")
    }
    println("")
    val map2 = hashMapOf.map { it.key.toUpperCase() }
    for (item in map2){
        print("$item    ")
    }
    println("")
    //TODO filter函数可以筛选，选择zuo操作
    val map3 = mutableListOf.filter { it.length > 5 }.map { it.toUpperCase() }
    for (item in map3){
        print("$item    ")
    }
    //TODO any和all函数。其中any函数用于判断集 合中是否至少存在一个元素满足指定条件，all函数用于判断集合中是否所有元素都满足指定条件
    val list2 = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
    val anyResult = list2.any { it.length <= 5 }  //TRUE 至少满足一种
    val allResult = list2.all { it.length <= 5 }    //全部满足  false
    println("anyResult is " + anyResult + ", allResult is " + allResult)

    //线程写法
    Thread(Runnable { println("开启线程") }).start()

    doStudy(null)

    val  a  = 1
    val  b = 2
    //TODO ?.和?:操作符区别  ?.判空的   ?:判断操作完赋值
    val c = if (a != null){
        a
    }else{
        b
    }

    val d = a ?: b

    println(getTextLengths(""))
    println(getTextLength(""))
}
fun getTextLengths(text: String?) = text?.length ?: 0

fun getTextLength(text: String?): Int {
    if (text != null) {
    return text.length
    }
    return 0
}

fun doStudy(study: Study?) {
    study?.readBook()
    study?.doHomework()
}
//TODO let函数是可以处理全局变量的判空问题的
fun doStudys(study: Study?) {
    study?.let {
        study.readBook()
        study.doHomework()
    }
}
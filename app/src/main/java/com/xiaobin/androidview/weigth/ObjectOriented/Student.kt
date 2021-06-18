package com.xiaobin.androidview.weigth.ObjectOriented

/**
 *data:2021/5/14
 *Author:renbin
 */
//class Student : Person() {
//    var sno = ""        //学号
//    var grade = 0       //年纪
//}

  class Student(val sno :String ,val grade : Int, name :String , age : Int) : Person(name,age) ,Study{
//    init {
//        println("sno is $sno")
//        println("grade is $grade")
//    }

    /**
     * 次构造函数
     */
    constructor(name: String , age: Int):this("",0,name,age){

    }

    constructor():this("",0){

    }

    override fun readBook() {
        println( "$name is reading.")
    }

//    override fun doHomework() {
//        println( "$name is doing homework.")
//    }
}
package com.xiaobin.androidview.weigth.ObjectOriented

/**
 *data:2021/5/14
 *Author:renbin
 */
fun main() {
    val person = Person("xiuxiu",28)
//    person.name = "xiuxiu"
//    person.age = 28
    person.eat()

    val student1 = Student();
    val student2 = Student("renbin",32);
    val student3 = Student("20098300886", 4,"renbin",32)
    student3.eat()
//    student3.readBook()
//    student3.doHomework()
    doStudy(student3)

    //TODO data关键字，可以让模型类自定实现equals()、hashCode()、toString()等方法
    val cellphone1 = Cellphone("Samsung", 1299.99)
    val cellphone2 = Cellphone("Samsung", 1299.99)
    val cellphone3 = Cellphone("Samsung1", 1299.99)
    println(cellphone1)
    println("cellphone1 equals cellphone2 " + (cellphone1 == cellphone2))
    println("cellphone3 equals cellphone2 " + (cellphone3 == cellphone2))
    println("-----------------------------------单例-------------------------------------------------")
    Singleton.SingletonTest()

}

/**
 * TODO 多态
 */
fun doStudy(study: Study){
    study.readBook()
    study.doHomework()
}
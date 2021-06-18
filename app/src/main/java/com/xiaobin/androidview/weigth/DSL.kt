package com.xiaobin.androidview.weigth

/**
 *data:2021/6/17
 *Author:renbin
 */
class Dependency{
    val libraries = ArrayList<String>()
    fun implementation(lib: String) {
        libraries.add(lib)
    }

    fun dependencies(block : Dependency.()-> Unit) : List<String>{
        var dependency = Dependency()
        dependency.block()
        return dependency.libraries
    }

}
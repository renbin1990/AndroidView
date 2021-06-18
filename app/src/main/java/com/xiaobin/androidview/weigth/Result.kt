package com.xiaobin.androidview.weigth

/**
 *data:2021/5/20
 *Author:renbin
 */
sealed class Result
class Success(val msg: String) : Result()
class Failure(val error: Exception) : Result()

fun getgetResultMsg(result: Result) = when(result){
    is Success -> println(result.msg)
    is Failure -> println(result.error.message)
}
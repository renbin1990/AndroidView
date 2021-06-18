package com.xiaobin.androidview.bean

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *data:2021/6/17
 *Author:renbin
 */
@Entity
data class Book(var name : String ,var pages : Int) {

    @PrimaryKey(autoGenerate = true)
    var id : Long = 0
}
package com.xiaobin.androidview.bean

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *data:2021/6/16
 *Author:renbin
 * 使用@Entity注解，将它声明成了一个实体类，然后在 User类中添加了一个id字段，
 * 并使用@PrimaryKey注解将它设为了主键，再把 autoGenerate参数指定成true，使得主键的值是自动生成的。
 */
@Entity
 data class User (var firstName: String, var lastName: String, var age: Int){

    @PrimaryKey(autoGenerate = true)
     var id : Long = 0
}
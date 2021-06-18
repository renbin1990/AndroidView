package com.xiaobin.androidview.DB

import androidx.room.*
import com.xiaobin.androidview.bean.User

/**
 *data:2021/6/16
 *Author:renbin
 */
@Dao
interface UserDao {

    @Insert
    fun inssetUser(user: User) : Long

    @Update
    fun updateUser(newUser: User)

    @Query("select * from User")
    fun loadAllUsers(): List<User>

    @Query("select * from User where age > :age")
    fun loadUsersOlderThan(age: Int): List<User>

    @Delete
    fun deleteUser(user: User)

    @Query("delete from User where lastName = :lastName")
    fun deleteUserByLastName(lastName: String): Int
}
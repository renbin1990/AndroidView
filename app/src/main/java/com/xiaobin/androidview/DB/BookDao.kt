package com.xiaobin.androidview.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.xiaobin.androidview.bean.Book

/**
 *data:2021/6/17
 *Author:renbin
 */
@Dao
interface BookDao {

    @Insert
    fun insertBook(book: Book): Long

    @Query("select * from Book")
    fun loadAllBook() : List<Book>
}
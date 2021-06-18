package com.xiaobin.androidview.weigth

/**
 *data:2021/5/26
 *Author:renbin
 */
object StringUtils {

    fun lettersCount(letter: String): Int {
        var count = 0;
        for (char in letter) {
            if (char.isLetter()) {
                count++
            }
        }
        return count
    }

    fun String.lettersCounts(): Int {
        var count = 0
        for (char in this) {
            if (char.isLetter()) {
                count++
            }
        }
        return count
    }
}
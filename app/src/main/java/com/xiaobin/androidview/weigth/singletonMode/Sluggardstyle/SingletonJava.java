package com.xiaobin.androidview.weigth.singletonMode.Sluggardstyle;

/**
 * data:2021/3/30
 * Author:renbin
 * 懒汉式-线程安全
 */
public class SingletonJava {
    public static SingletonJava instence;

    private SingletonJava() {

    }

    public static synchronized SingletonJava getInstance() {
        if (instence == null) {
            instence = new SingletonJava();
        }
        return instence;
    }
}

package com.xiaobin.androidview.weigth.singletonMode.SluggardstyleOne;

/**
 * data:2021/3/30
 * Author:renbin
 * 懒汉式
 */
public class SingletonJava {
    public static SingletonJava instence;

    private SingletonJava() {

    }

    public static SingletonJava getInstance() {
        if (instence == null) {
            instence = new SingletonJava();
        }
        return instence;
    }
}

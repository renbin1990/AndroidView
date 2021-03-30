package com.xiaobin.androidview.weigth.singletonMode.Hungrystyle;

/**
 * data:2021/3/30
 * Author:renbin
 * java饿汉式
 */
public class SingletonJava {
    private static SingletonJava instence = new SingletonJava();
    private SingletonJava(){

    }
    public static SingletonJava getInstance(){
        return instence;
    }
}

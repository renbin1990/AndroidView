package com.xiaobin.androidview.weigth.singletonMode.DCL;

/**
 * data:2021/3/30
 * Author:renbin
 * 双重检查模式-DCL
 */
public class SingletonJava {
    private volatile static SingletonJava instence;
    private SingletonJava(){

    }

    public static SingletonJava getInstance(){
        if (instence == null){
            synchronized (SingletonJava.class){
                if (instence==null){
                    instence = new SingletonJava();
                }
            }
        }
        return instence;
    }
}

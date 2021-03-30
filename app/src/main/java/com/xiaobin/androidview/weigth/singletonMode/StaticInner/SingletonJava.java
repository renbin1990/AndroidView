package com.xiaobin.androidview.weigth.singletonMode.StaticInner;

/**
 * data:2021/3/30
 * Author:renbin
 * 静态内部类单例模式
 */
public class SingletonJava {
    private SingletonJava(){
    }

    private static class SingletonJavaHolder{
        private static final  SingletonJava sInstance = new SingletonJava();
    }

    public static SingletonJava getInstance(){
        return SingletonJavaHolder.sInstance;
    }
}

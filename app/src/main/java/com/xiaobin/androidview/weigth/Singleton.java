package com.xiaobin.androidview.weigth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * data:2021/3/22
 * Author:renbin
 */
class Singleton {
    private volatile static Singleton instence = null;
    public Singleton getInstance(){
        if (instence == null){
            synchronized (this){
                if (instence == null){
                    instence = new Singleton();
                }
            }
        }
        return instence;
    }

}

package com.xiaobin.androidview.weigth;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

/**
 * data:2021/3/22
 * Author:renbin
 */
public class AsyncTaskDemo {
    @SuppressLint("StaticFieldLeak")
    AsyncTask task = new AsyncTask() {
        @Override
        protected Object doInBackground(@SuppressLint("StaticFieldLeak") Object[] objects) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    };

    public static void main(String[] args) {

    }
}

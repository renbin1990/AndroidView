package com.xiaobin.androidview.weigth

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import android.widget.ImageView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.ImageLoader.ImageCache
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.xiaobin.androidview.R

/**
 *data:2021/3/23
 *Author:renbin
 */
object VolleyNetUtils {

    fun newRequestQueue(url : String ,context: Context){
        val queue = Volley.newRequestQueue(context)
        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                // Display the first 500 characters of the response string.
                Log.e("---->","Response is: ${response}")
            },
            {  Log.e("---->", "That didn't work!" )})

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }

    //加载网络图片 已过时
    fun ImageRequestPic(url : String ,imgview :ImageView){
        val imageRequest = ImageRequest(url, {
            imgview.setImageBitmap(it)
        },0,0,Bitmap.Config.RGB_565, {
            //设置默认图片
        });
    }

    fun ImageLoaderPic(url : String ,imgview :ImageView,context: Context){
//        val mQueue = Volley.newRequestQueue(context)
//
//        val imageLoader = ImageLoader(mQueue, ImageLoader.ImageCache())
//        val imageListener = ImageLoader.getImageListener(imgview, R.mipmap.ic_launcher,R.mipmap.ic_launcher)
//        imageLoader.get(url,imageListener)
    }
}
package com.xiaobin.androidview.weigth

import android.provider.Settings
import android.text.TextUtils
import com.xiaobin.androidview.bean.NameValuePair
import java.io.BufferedWriter
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

/**
 *data:2021/3/23
 *Author:renbin
 */
object HttpURLConnectionUtils {

    fun postParmas(output : OutputStream , pramasList : List<NameValuePair>){
        var stringBuilder = StringBuilder();
        for (pair in pramasList){
            if (!TextUtils.isEmpty(pair.toString())) {stringBuilder.append("&")}
            stringBuilder.append(URLEncoder.encode(pair.name),"UTF-8")
            stringBuilder.append("==")
            stringBuilder.append(URLEncoder.encode(pair.valur),"UTF-8")
            var bufferedWriter = BufferedWriter(OutputStreamWriter(output,"UTF-8"));
            bufferedWriter.write(stringBuilder.toString())
            bufferedWriter.flush()
            bufferedWriter.close()
        }
    }

    fun getHttpURLConnection(url : String): HttpURLConnection {
        var mUrl = URL(url)
        var  mHttpURLConnection = mUrl.openConnection() as HttpURLConnection
        //设置链接时间
        mHttpURLConnection.connectTimeout = 15000
        //设置超时时间
        mHttpURLConnection.readTimeout = 15000
        //设置请求方式
        mHttpURLConnection.requestMethod = "POST"
        //添加Header
        mHttpURLConnection.setRequestProperty("Connection","Keep-Alive")
        //接受输入流
        mHttpURLConnection.doInput = true
        //传递参数时需要开启
        mHttpURLConnection.doOutput = true
        return mHttpURLConnection;
    }
}
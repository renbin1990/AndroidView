package com.xiaobin.androidview.weigth.okhttp

import android.app.ProgressDialog
import android.content.Context
import android.text.TextUtils
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

abstract class SpotsCallBack<T> : BaseCallback<T> {
    private var dialog: ProgressDialog? = null
    private var isShow: Boolean = true
 
    constructor(mContext: Context) {
        try {
            if (dialog == null)
                dialog = ProgressDialog(mContext)
            setMessage("加载中......")
        } catch (e: Exception) {
//            e.printStackTrace()
        }
    }
 
    constructor(mContext: Context, isShow: Boolean) {
        try {
            if (dialog == null)
                dialog = ProgressDialog(mContext)
            this.isShow = isShow
            setMessage("加载中......")
        } catch (e: Exception) {
//            e.printStackTrace()
        }
 
    }
 
    constructor(context: Context, message: String) {
        try {
            if (dialog == null)
                dialog = ProgressDialog(context)
        } catch (e: Exception) {
//            e.printStackTrace()
        }
 
        setMessage(message)
    }
 
 
 
    override fun onRequestBefore(request: Request) {
        if (isShow) showDialog()
    }
 
    override fun onFailure(request: Request, e: IOException) {
        dismissDialog()
    }
 
    override fun onProgress(response: Response, total: Long, current: Long) {
 
    }
 
    abstract override fun onSuccess(response: Response, t: Any)
 
    abstract override fun onError(response: Response, code: Int, e: Exception)
 
    override fun onResponse(response: Response) {
        dismissDialog()
    }
 
    private fun showDialog() {
        try {
            if (dialog != null && !dialog!!.isShowing)
                dialog?.show()
        } catch (e: Exception) {
//            e.printStackTrace()
        }
 
    }
 
    private fun dismissDialog() {
        try {
            if (dialog != null && dialog!!.isShowing)
                dialog?.dismiss()
        } catch (e: Exception) {
//            e.printStackTrace()
        }
 
    }
 
    private fun setMessage(message: String) {
        try {
            if (dialog != null && !TextUtils.isEmpty(message))
                dialog!!.setMessage(message)
        } catch (e: Exception) {
//            e.printStackTrace()
        }
 
    }
}
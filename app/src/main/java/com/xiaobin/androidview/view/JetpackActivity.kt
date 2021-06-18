package com.xiaobin.androidview.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.xiaobin.androidview.DB.AppDatabase
import com.xiaobin.androidview.R
import com.xiaobin.androidview.base.BaseActivity
import com.xiaobin.androidview.bean.User
import com.xiaobin.androidview.view.Lifecycles.MyObserver
import com.xiaobin.androidview.view.viewModel.JetpackViewModel
import com.xiaobin.androidview.view.viewModel.JetpackViewModelFactory
import com.xiaobin.androidview.weigth.SimpleWorker
import kotlinx.android.synthetic.main.activity_jetpack.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

/**
 *data:2021/6/15
 *Author:renbin
 */
class JetpackActivity : BaseActivity() {

    lateinit var viemodel: JetpackViewModel
    lateinit var sp: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jetpack)
        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)
        //TODO viewModel
        viemodel = ViewModelProvider(this,
            JetpackViewModelFactory(countReserved)).get(JetpackViewModel::class.java)
        //    viemodel = ViewModelProvider(this).get(JetpackViewModel::class.java)
        plusOneBtn.setOnClickListener {
            //       viemodel.counter++
            //        refreshCounter()
        }
        clearBtn.setOnClickListener {
            //          viemodel.counter = 0
            //           refreshCounter()
        }
        //       refreshCounter()

        //TODO Lifecycles
        lifecycle.addObserver(MyObserver())

        //TODO LiveData
        plusOneBtn.setOnClickListener {
            viemodel.plusOne()
        }
        clearBtn.setOnClickListener {
            viemodel.clear()
        }

        viemodel.counter.observe(this, Observer {
            infoText.text = it.toString()
        })

        //TODO Room
        val userDao = AppDatabase.getDatabase(this).userDao()
        val user1 = User("Tom", "Brady", 40)
        val user2 = User("Tom", "Hanks", 63)
        addDataBtn.setOnClickListener {
            thread {
                user1.id = userDao.inssetUser(user1)
                user2.id = userDao.inssetUser(user2)
            }
        }
        updateDataBtn.setOnClickListener {
            thread {
                user1.age = 42
                userDao.updateUser(user1)
            }
        }
        deleteDataBtn.setOnClickListener {
            thread {
                userDao.deleteUserByLastName("Hanks")
            }
        }
        queryDataBtn.setOnClickListener {
            thread {
                for (user in userDao.loadAllUsers()) {
                    Log.d("MainActivity", user.toString())
                }
            }
        }

        //TODO WorkManager
        doWorkBtn.setOnClickListener {
            val request = PeriodicWorkRequest.Builder(SimpleWorker::class.java, 15, TimeUnit.MINUTES)
                    //设置任务5分钟后执行
                .setInitialDelay(5,TimeUnit.MINUTES)
                    //添加标签，可以通过标签取消任务
                .addTag("simple")
                .build()
            WorkManager.getInstance(this).enqueue(request)
        }

        cancleWorkBtn.setOnClickListener {
            WorkManager.getInstance(this).cancelAllWorkByTag("simple")
        }
    }

    private fun refreshCounter() {
        infoText.text = viemodel.counter.toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            //     putInt("count_reserved",viemodel.counter)
            putInt("count_reserved", viemodel.counter.value ?: 0)
        }
    }
}
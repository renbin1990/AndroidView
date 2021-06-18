package com.xiaobin.androidview.view

import android.animation.*
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.*
import com.xiaobin.androidview.R
import com.xiaobin.androidview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_animator.*

/**
 *Time:
 *Author:renbin
 */
class AnimatorActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animator)

        //一、ObjectAnimator
        //translationX和translationY：用来沿着X轴或者Y轴进行平移。
        //• rotation、rotationX、rotationY：用来围绕View的支点进行旋转。
        //•   PrivotX和PrivotY：控制View对象的支点位置，围绕这个支点进行旋转和缩放变换处理。默认该支点 位置就是View对象的中心点。
        //• alpha：透明度，默认是1（不透明），0代表完全透明。
        //• scaleX scaleY：持Ｘ方向　和Ｙ方向缩放
        //• x和y：描述View对象在其容器中的最终位置。
        //透明动画
        var objectAnimator = ObjectAnimator.ofFloat(tv_animator,"alpha",1f,0f,1f)
        objectAnimator.duration = 2000
        objectAnimator.start()

        //平移动画-X
        var objectAnimator1 = ObjectAnimator.ofFloat(tv_animator,"translationX",200f)
        objectAnimator1.duration = 2000
        objectAnimator1.start()

        //ValueAnimator
        var valueAnimator = ValueAnimator.ofFloat(0f,100f)
        valueAnimator.setTarget(tv_animator1)
        valueAnimator.duration = 1000
        valueAnimator.start()
        valueAnimator.addUpdateListener {
            val  float = it.getAnimatedValue()
            Log.e("---->" ,""+float)
        }

        //3.动画的监听
        //需要注意的是，在使用ObjectAnimator的时候，要操作的属性必须要有get和set方法，不然 ObjectAnimator
        // 就无法生效。如果一个属性没有get、set方法，也可以通过自定义一个属性类或包装类来间 接地给这个属性增加get和set方法。
        // 现在来看看如何通过包装类的方法给一个属性增加get和set方法
        var objectAnimator2 = ObjectAnimator.ofFloat(btn_animator,"translationY",200f)
        objectAnimator2.duration = 2000
        objectAnimator2.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                Log.e("---->","动画执行开始")
            }

            override fun onAnimationEnd(animation: Animator) {
                /**
                 * 大部分情况下，我们都要监听的是这个，在动画结束后，执行什么操作
                 * 这里，我们只弹出一个Toast。
                 */
                Log.e("---->","动画执行结束")
            }

            override fun onAnimationCancel(animation: Animator) {
                Log.e("---->","动画执行取消")
            }

            override fun onAnimationRepeat(animation: Animator) {

            }
        })
        objectAnimator2.start()

        //组合动画——AnimatorSet
        //Builder 类采用了建造者模式，每次调用方法时都返回  Builder 自身用于继续构建。 AnimatorSet.Builder中包括以下4个方法。
        //• after（Animator anim）：将现有动画插入到传入的动画之后执行。
        //• after（long delay）：将现有动画延迟指定毫秒后执行。
        //• before（Animator anim）：将现有动画插入到传入的动画之前执行。
        //• with（Animator anim）：将现有动画和传入的动画同时执行。
        //AnimatorSet正是通过这几种方法来控制动画播放顺序的
        val  objectAnimator3 = ObjectAnimator.ofFloat(tv_animator2,"translationX",0f,200f,0f)
        val  objectAnimator4 = ObjectAnimator.ofFloat(tv_animator2,"scaleX",1.0f,2.0f,1.0f)
        val  objectAnimator5 = ObjectAnimator.ofFloat(tv_animator2,"rotationX",0f,90f,0f)
        val animatorSet = AnimatorSet()
        animatorSet.duration = 1000
        //设定执行顺序
        animatorSet.play(objectAnimator3).with(objectAnimator4).after(objectAnimator5)
        animatorSet.start()

        //5.组合动画——PropertyValuesHolder
        val propertyValuesHolder1 = PropertyValuesHolder.ofFloat("scaleX",1f,1.5f)
        val propertyValuesHolder2 = PropertyValuesHolder.ofFloat("rotationX",1f,90f,0f)
        val propertyValuesHolder3 = PropertyValuesHolder.ofFloat("alpha",1f,0.3f,1f)
        val  objectAnimator6 = ObjectAnimator.ofPropertyValuesHolder(tv_animator3,propertyValuesHolder1,propertyValuesHolder2,propertyValuesHolder3)
        objectAnimator6.setDuration(1000).start()

        //6.在XML中使用属性动画
        //在res文件中新建animator文件，在里面新建一个 scale.xml
        val animator = AnimatorInflater.loadAnimator(this,R.animator.scale)
        animator.setTarget(tv_animator4)
        animator.start()
    }
}
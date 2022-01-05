package com.example.imooc_pingtu.view

import android.content.Context
import android.util.AttributeSet
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyGameLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : GamePintuLayout(context, attrs),LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resumeFun(){
        resume()
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pasueFun(){
        pause()
    }

}
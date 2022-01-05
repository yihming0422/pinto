package com.example.imooc_pingtu

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore.Images.Media.getBitmap
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.example.imooc_pingtu.extension.showToast
import com.example.imooc_pingtu.utils.AlertDialogUtilsKt
import com.example.imooc_pingtu.utils.isDebug
import com.example.imooc_pingtu.utils.yes
import com.example.imooc_pingtu.view.GamePintuLayout
import com.example.imooc_pingtu.view.MyGameLayout
import com.example.spdemo.sharedpreferences.Settings
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity(), GamePintuLayout.GamePintuListener {

    private lateinit var vm: PicVM

    val mGamePintuLayout by lazy { findViewById<MyGameLayout>(R.id.id_gamepintu) }
    val mLevel by lazy { findViewById<TextView>(R.id.id_level) }
    val mTime by lazy { findViewById<TextView>(R.id.id_time) }
    lateinit var bitmap: Bitmap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var i = 1
        mGamePintuLayout.context = this

        isDebug(yesOper = {
            mLevel.setOnClickListener {
                i++
                mGamePintuLayout.nextLevel()
                mLevel.text = "" + i
            }
            mGamePintuLayout.setTimeEnabled(false)
        }, noOper = {
            mGamePintuLayout.setTimeEnabled(true)
        })


        mGamePintuLayout.setOnGamePintuListener(this)

        lifecycle.addObserver(mGamePintuLayout)
    }

    private val TAG = "MainActivity"
    override fun nextLevel(nextLevel: Int) {
        val debug = BuildConfig.DEBUG
        debug.yes {

        }
        Settings.levelString = nextLevel.toString()
        showToast(Settings.levelString)
        if (nextLevel == 14) {
            val kType = AlertDialogUtilsKt.DialogParams().also {
                it.cancelable = false
                it.msg = "pass"
                it.title = "Game Info"
                it.textPostive = "恭喜你 通关了!"
                it.listenerPostive = View.OnClickListener {

                }

            }
            val alertDialogUtilsKt = AlertDialogUtilsKt
            with(alertDialogUtilsKt) {
                showPositiveButtonDialog(this@MainActivity, kType)
            }
        }
        showToast("GAME PASS!!!")
        val kType = AlertDialogUtilsKt.DialogParams().also {
            it.cancelable = false
            it.msg = "LEVEL UP !!!"
            it.title = "Game Info"
            it.textPostive = "NEXT LEVEL"
            it.listenerPostive = View.OnClickListener {
                mGamePintuLayout.nextLevel()
                mLevel.text = "" + nextLevel
            }

        }
        val alertDialogUtilsKt = AlertDialogUtilsKt
        with(alertDialogUtilsKt) {
            showPositiveButtonDialog(this@MainActivity, kType)
        }
    }

    override fun timechanged(currentTime: Int) {
        mTime.text = "" + currentTime
    }

    override fun gameover() {
        showToast("GAME OVER!!!")
        val kType = AlertDialogUtilsKt.DialogParams().also {
            it.cancelable = false
            it.msg = "Game over !!!"
            it.title = "Game Info"
            it.textPostive = "RESTART"
            it.textNegative = "QUIT"
            it.listenerPostive = View.OnClickListener {
                mGamePintuLayout.restart()
            }
            it.listenerNegative = View.OnClickListener {
                finish()
            }
        }
        val alertDialogUtilsKt = AlertDialogUtilsKt
        with(alertDialogUtilsKt) {
            showPositiveButtonNegativeButtonDialog(this@MainActivity, kType)
        }
    }

    private fun getBitmapFun(data: Data) {
        Glide.with(this)
            .asBitmap()
            .load(data.uri)
            .into(object : SimpleTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    bitmap = resource
                }
            })
    }

}

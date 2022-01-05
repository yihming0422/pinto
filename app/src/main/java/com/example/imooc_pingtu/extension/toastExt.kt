package com.example.imooc_pingtu.extension

import android.content.Context
import android.widget.Toast

inline fun Context.showToast(msg:String)
 = Toast.makeText(this,msg,Toast.LENGTH_SHORT).apply { show() }
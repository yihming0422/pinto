package com.example.imooc_pingtu.utils

import com.example.imooc_pingtu.BuildConfig


sealed class BooleanExt<out T>

object Otherwise: BooleanExt<Nothing>()
class WithData<T>(val data: T): BooleanExt<T>()

inline fun <T> Boolean.yes(block: ()->T) =
    when {
        this -> {
            WithData(block())
        }
        else -> {
            Otherwise
        }
    }

inline fun <T> Boolean.no(block: () -> T) = when {
    this -> Otherwise
    else -> {
        WithData(block())
    }
}

inline fun <T> BooleanExt<T>.otherwise(block: ()->T): T =
    when(this){
        is Otherwise -> block()
        is WithData -> this.data
    }

inline fun isDebug(yesOper:()->Unit,noOper:()->Unit){
    val debug = BuildConfig.DEBUG
    debug.yes(yesOper).otherwise(noOper)
}
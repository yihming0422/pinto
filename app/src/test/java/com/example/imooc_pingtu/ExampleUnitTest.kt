package com.example.imooc_pingtu

import org.junit.Test

import org.junit.Assert.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    // 创建接口
    @Test
    fun too() {
        val also = ArrayList<User>().also { list->
            repeat(10){
                list.add(User(it.toString()))
            }

        }
        also.forEach{
            println(it)
        }
    }

    fun <T> to(content: T) {
        when (content) {
            is String -> println("is string")
            is Int -> println("is int")
            is Boolean -> println("is bool")
            else -> println("isnot defalut type")
        }

    }

    class User(val name: String){
        override fun toString(): String {
            return "User(name='$name')"
        }
    }

}
package com.example.spdemo.sharedpreferences

import com.example.imooc_pingtu.AppContext


object Settings{
    var email : String by Preference(AppContext,"emailName", "")
    var password :String by Preference(AppContext,"password","")
    var level : Long by Preference(AppContext,"level",default =1)
    var levelString : String by Preference(AppContext,"levelStr","")
}
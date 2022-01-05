package com.example.imooc_pingtu

data class PicBean(
    val code: Int,
    val `data`: List<Data>,
    val msg: Any
)

data class Data(
    val id: Int,
    val uri: String
)
package com.example.imooc_pingtu

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface TranslateService {

    @GET("query/pic")
    suspend fun getPic():PicBean

    companion object {

        private const val BASE_URL = "http://47.103.81.155:8888/"
        private var service: TranslateService? = null

        /**
         * 通过Retrofit的动态代理生成TranslateService实现类
         */
        fun getApi(): TranslateService {
            if (null == service) {
                val httpLoggingInterceptor =
                    HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

                val client = OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .build()

                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                service = retrofit.create(TranslateService::class.java)
            }

            return service!!
        }
    }
}
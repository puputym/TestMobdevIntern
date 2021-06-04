package com.puput.testsuitmediamobdev.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InstanceAPI {
    private const val BASE_URL = "http://www.mocky.io/"

    fun getRetrofitAPI(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
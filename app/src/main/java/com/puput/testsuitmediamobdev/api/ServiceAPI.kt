package com.puput.testsuitmediamobdev.api

import com.puput.testsuitmediamobdev.model.GuestModel
import retrofit2.Call
import retrofit2.http.GET

interface ServiceAPI {
    @GET("v2/596dec7f0f000023032b8017")
    fun getGuest(): Call<ArrayList<GuestModel>>
}

package com.puput.testsuitmediamobdev.guest

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.puput.testsuitmediamobdev.api.InstanceAPI
import com.puput.testsuitmediamobdev.api.ServiceAPI
import com.puput.testsuitmediamobdev.model.GuestModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GuestViewModel : ViewModel() {
    val rvData = MutableLiveData<ArrayList<GuestModel>>()

    fun getDataGuest(): MutableLiveData<ArrayList<GuestModel>> {
        return rvData
    }

    fun setDataGuest() {
        val retrofitAPI = InstanceAPI.getRetrofitAPI().create(ServiceAPI::class.java)
        val call = retrofitAPI.getGuest()
        call.enqueue(object : Callback<ArrayList<GuestModel>?> {
            override fun onResponse(
                call: Call<ArrayList<GuestModel>?>,
                response: Response<ArrayList<GuestModel>?>
            ) {
                if (response.isSuccessful) {
                    rvData.postValue(response.body())
                } else {
                    return
                }
            }

            override fun onFailure(call: Call<ArrayList<GuestModel>?>, t: Throwable) {
                Log.d("Failure", t.message.toString())
            }
        })
    }
}
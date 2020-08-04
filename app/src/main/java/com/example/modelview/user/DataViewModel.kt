package com.example.modelview.user

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modelview.model.Reqres
import com.google.gson.Gson
import kotlinx.coroutines.Job
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.SharedPreferences
import android.provider.VoicemailContract
import android.renderscript.Sampler
import androidx.work.Operation
import org.kodein.di.KodeinContext

class DataViewModel : ViewModel() {

    private lateinit var job: Job
    val userData = MutableLiveData<Reqres>()
    private val status = MutableLiveData<Resource<Reqres>>()

    fun getStatus(): LiveData<Resource<Reqres>> {
        return status
    }

    fun fetchData(): Call<Reqres> {

        val interfac = DataAPI.invoke().getData()
        interfac.enqueue( object: Callback<Reqres> {
            override fun onResponse(
                call: Call<Reqres>,
                response: Response<Reqres>
            ) {
//                val jsonDataList: String = Gson().toJson(userData)
//                Log.d("mmmm","mmmm")
//                val data = sharedPreferencesData.save("Datalist", jsonDataList) as String
                status.value = Resource.success(response.body())
//                userData.postValue(Resource.success(data))
            }

            override fun onFailure(call: Call<Reqres>, t: Throwable) {
//                val json = sharedPreferencesData.getValueString("Datalist")
////                if (Resource.Success()) {}
//                val GsonDataList: Reqres = Gson().fromJson(json, Reqres::class.java)
                status.value = (Resource.error(t))
            }
        })
        return interfac

    }

    override fun onCleared() {
        super.onCleared()

    }
}


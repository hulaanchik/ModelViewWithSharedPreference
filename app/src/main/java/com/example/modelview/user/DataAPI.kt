package com.example.modelview.user

import com.example.modelview.model.Reqres
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DataAPI {

    @GET("users?page=2")
    fun getData() : Call<Reqres>

    companion object {
         fun invoke() : DataAPI {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://reqres.in/api/")
                .build()
                .create(DataAPI::class.java)
        }
    }
}
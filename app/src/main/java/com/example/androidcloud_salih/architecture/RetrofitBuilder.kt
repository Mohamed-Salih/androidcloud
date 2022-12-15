package com.example.androidcloud_salih.architecture

import com.google.gson.GsonBuilder
import com.example.androidcloud_salih.boredActivity.remote.BoredActivityEndpoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://www.boredapi.com/api/activity")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
        .build()


    fun getBoredActivity(): BoredActivityEndpoint = retrofit.create(BoredActivityEndpoint::class.java)

}
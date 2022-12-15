package com.example.androidcloud_salih.boredActivity.remote

import com.example.androidcloud_salih.boredActivity.model.BoredActivityRetrofit
import retrofit2.http.GET

interface BoredActivityEndpoint {

    @GET("random")
    suspend fun getRandomQuote() : BoredActivityRetrofit
}
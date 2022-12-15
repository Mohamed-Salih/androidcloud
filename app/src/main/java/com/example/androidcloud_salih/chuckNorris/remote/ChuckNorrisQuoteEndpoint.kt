package com.example.androidcloud_salih.chuckNorris.remote

import com.example.androidcloud_salih.chuckNorris.model.ChuckNorrisRetrofit
import retrofit2.http.GET

interface ChuckNorrisQuoteEndpoint {

    @GET("random")
    suspend fun getRandomQuote() : ChuckNorrisRetrofit
}
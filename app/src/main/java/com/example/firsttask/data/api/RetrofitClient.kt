package com.example.firsttask.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO object instead class
object RetrofitClient {

        val url = "https://a1332445bf314d48a1396433b5df0a03.api.mockbin.io"

        val apiService : ApiService = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

}
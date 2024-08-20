package com.example.firsttask.data.api

import com.example.firsttask.data.model.TaskVoucher
import retrofit2.http.GET

interface ApiService {
    @GET("https://2961bb48990f4396ba6eed853b1926d0.api.mockbin.io/")
    suspend fun getData() : TaskVoucher
}
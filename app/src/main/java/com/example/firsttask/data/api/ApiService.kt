package com.example.firsttask.data.api

import com.example.firsttask.data.model.Item
import com.example.firsttask.data.model.voucherX
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("https://a1332445bf314d48a1396433b5df0a03.api.mockbin.io")
    suspend fun getData() : Response<voucherX>
}
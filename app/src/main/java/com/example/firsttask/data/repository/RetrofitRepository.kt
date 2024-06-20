package com.example.firsttask.data.repository

import com.example.firsttask.data.api.RetrofitClient
import com.example.firsttask.data.model.Item
import com.example.firsttask.data.model.Result
import retrofit2.Response

class RetrofitRepository {
    suspend fun getVouchers() : Response<List<Item>>{
        return RetrofitClient.apiService.getData()
    }
}
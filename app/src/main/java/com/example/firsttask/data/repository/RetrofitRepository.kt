package com.example.firsttask.data.repository

import com.example.firsttask.data.api.RetrofitClient
import com.example.firsttask.data.model.Item

class RetrofitRepository {
    suspend fun getVouchers() : List<Item>{
        return RetrofitClient.apiService.getData().result?.items?: listOf()
    }
}
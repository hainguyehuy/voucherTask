package com.example.firsttask.ui.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firsttask.data.model.Item
import com.example.firsttask.data.repository.RetrofitRepository
import kotlinx.coroutines.launch

class VoucherViewModel : ViewModel() {
    private val retrofitRepository = RetrofitRepository()
    private val _vouchers = MutableLiveData<List<Item>>()
    var vouchers: LiveData<List<Item>> = _vouchers
    val errorMessage = MutableLiveData<String>()

    @SuppressLint("SuspiciousIndentation")
    fun fetchVoucher()  {
        viewModelScope.launch {
            try {
                val response = retrofitRepository.getVouchers()
                _vouchers.postValue(response)
                Log.d("data", "${response.size}")
            } catch (e: Exception) {
                Log.e("error", "$errorMessage")
            }
        }
    }
}

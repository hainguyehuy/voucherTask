package com.example.firsttask.ui.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firsttask.data.model.Item
import com.example.firsttask.data.repository.RetrofitRepository
import com.example.firsttask.ui.adapter.VoucherAdapter
import kotlinx.coroutines.launch

class VoucherViewModel : ViewModel() {
    private val retrofitRepository = RetrofitRepository()
    private val _vouchers = MutableLiveData<List<Item>>()
    var vouchers : LiveData<List<Item>> = _vouchers
    private val errorMessage = MutableLiveData<String>()

    var amountSelected : MutableLiveData<Int> = MutableLiveData(0)

    @SuppressLint("SuspiciousIndentation")
    fun fetchVoucher()  {
        viewModelScope.launch {
            try {
                val response = retrofitRepository.getVouchers()
                _vouchers.postValue(response)
                Log.d("data", "${response.size}")
            } catch (e: Exception) {
                Log.e("error", "${e.message.toString()}")
            }
        }
    }
    fun updateAmountSelected(count : Int){
        amountSelected.postValue(count)
    }




}

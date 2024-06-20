package com.example.firsttask.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firsttask.data.model.Item
import com.example.firsttask.data.model.Result
import com.example.firsttask.data.repository.RetrofitRepository
import kotlinx.coroutines.launch

class VoucherViewModel : ViewModel() {
    private val retrofitRepository = RetrofitRepository()
    private val _vouchers = MutableLiveData<List<Item>>()
    var vouchers : LiveData<List<Item>> = _vouchers
    val errorMessage = MutableLiveData<String>()

    fun fetchVoucher(){
        viewModelScope.launch {
            try {
                val response = retrofitRepository.getVouchers()
                if (response.isSuccessful){
                    _vouchers.postValue(response.body())
                }else{
                    errorMessage.postValue("Errors : ${response.message()}")
                }
            }catch (e: Exception){
                //error
            }
        }
    }

}
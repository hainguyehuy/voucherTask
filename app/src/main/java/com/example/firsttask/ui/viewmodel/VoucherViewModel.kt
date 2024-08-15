package com.example.firsttask.ui.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firsttask.data.model.ItemVoucherState
import com.example.firsttask.data.repository.RetrofitRepository
import kotlinx.coroutines.launch

class VoucherViewModel : ViewModel() {
    private val retrofitRepository = RetrofitRepository()
    private val _vouchers = MutableLiveData<List<ItemVoucherState>>()
    var vouchers: LiveData<List<ItemVoucherState>> = _vouchers

    @SuppressLint("SuspiciousIndentation")
    fun fetchVoucher() {
        viewModelScope.launch {
            try {
                val response = retrofitRepository.getVouchers()
                val newData = response.map {
                    ItemVoucherState.mapItemVoucher(it)
                }

                _vouchers.postValue(newData)

                Log.d("data", "${response.size}")
            } catch (e: Exception) {
                Log.e("error", "${e.message.toString()}")
            }

        }
    }
    var amountSelected = MutableLiveData<Int>()
    var sgdSelected = MutableLiveData<Double>()
    var checked = MutableLiveData<Boolean>()

    fun updateAmountSelected(position: Int) {
        amountSelected.postValue(position)
    }

    fun updateSGDSelected(sum: Double) {
        sgdSelected.postValue(sum)
    }

    fun updateSelectedItem(isChecked: Boolean) {
        checked.postValue(isChecked)
    }

    fun onClick(itemVoucherState: ItemVoucherState) {

    }

}

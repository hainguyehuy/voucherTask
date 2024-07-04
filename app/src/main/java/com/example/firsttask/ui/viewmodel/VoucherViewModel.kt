package com.example.firsttask.ui.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firsttask.data.model.Item_Voucher
import com.example.firsttask.data.repository.RetrofitRepository
import kotlinx.coroutines.launch

class VoucherViewModel : ViewModel() {
    private val retrofitRepository = RetrofitRepository()
    private val _vouchers = MutableLiveData<List<Item_Voucher>>()
    var vouchers: LiveData<List<Item_Voucher>> = _vouchers

    var amountSelected = MutableLiveData<Int>()
    var sgdSelected = MutableLiveData<Double>()
    var checked = MutableLiveData<Boolean>()

    @SuppressLint("SuspiciousIndentation")
    fun fetchVoucher() {
        viewModelScope.launch {
            try {
                val response = retrofitRepository.getVouchers()
                var arrayList = ArrayList<Item_Voucher>()
                response.forEach() { item ->
                    arrayList.addAll(
                        listOf(
                            Item_Voucher(
                                item.amount.toDouble(),
                                item.provider,
                                item.exp,
                                true,
                                item.name,
                                item.minSpend,
                                item.id
                            )
                        )
                    )
                }
                _vouchers.postValue(arrayList)
                Log.d("data", "${response.size}")
            } catch (e: Exception) {
                Log.e("error", "${e.message.toString()}")
            }
        }

    }

    fun updateAmountSelected(count: Int) {
        amountSelected.postValue(count)
    }

    fun updateSGDSelected(sum: Double) {
        sgdSelected.postValue(sum)
    }
    fun updateSelectedItem(isChecked : Boolean){
        checked.postValue(isChecked)
    }


}

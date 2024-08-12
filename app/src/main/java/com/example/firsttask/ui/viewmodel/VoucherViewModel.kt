package com.example.firsttask.ui.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firsttask.data.model.Item_Voucher
import com.example.firsttask.data.repository.RetrofitRepository
import com.example.firsttask.ui.view.ButtonClickEvent
import kotlinx.coroutines.launch

class VoucherViewModel : ViewModel() {
    private val retrofitRepository = RetrofitRepository()
    private val _vouchers = MutableLiveData<List<Item_Voucher>>()
    var vouchers: LiveData<List<Item_Voucher>> = _vouchers

    var amountSelected = MutableLiveData<Int>()
    var sgdSelected = MutableLiveData<Double>()
    var checked = MutableLiveData<Boolean>()
    var sum : Double = 0.0
    var count : Int = 0
    var event : ButtonClickEvent? = null
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
                                false,
                                item.name,
                                item.minSpend,
                                item.id,
                                item.type
                            )
                        )
                    )
                }

                arrayList.sortBy { it.type }
                _vouchers.postValue(arrayList)

                Log.d("data", "${response.size}")
            } catch (e: Exception) {
                Log.e("error", "${e.message.toString()}")
            }
        }

    }
    fun eventClickSelectAll(){
        val voucher = _vouchers.value
        voucher?.forEach {
            if(it.type ==1 && it.checked){
                it.checked = !it.checked
                count ++
                sum += it.amountt
            }
        }

    }
    fun updateAmountSelected(positon: Int) {
        amountSelected.postValue(positon)
    }

    fun updateSGDSelected(sum: Double) {
        sgdSelected.postValue(sum)
    }
    fun updateSelectedItem(isChecked : Boolean){
        checked.postValue(isChecked)
    }


}

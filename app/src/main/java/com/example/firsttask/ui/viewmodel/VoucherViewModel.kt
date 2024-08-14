package com.example.firsttask.ui.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firsttask.data.model.ItemVoucherState
import com.example.firsttask.data.model.Item_Voucher
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
//                response.forEach() { i ->
//                    arrayList.addAll(
////                        listOf(
////                            ItemVoucherState(
////                                item.id.toString(),
////                                item.amount.toDouble(),
////                                item.provider,
////                                item.name
//////                                item.amount.toDouble(),
//////                                item.provider,
//////                                item.exp,
//////                                false,
//////                                item.name,
//////                                item.minSpend,
//////                                item.id.toString(),
//////                                item.type
////                            )
////                        )
//                )
//                }




        }
    }
    var amountSelected = MutableLiveData<Int>()
    var sgdSelected = MutableLiveData<Double>()
    var checked = MutableLiveData<Boolean>()
//    private var sum: Double = 0.0
//    private var count: Int = 0
//    private var event: ButtonClickEvent? = null
    //    fun eventClickSelectAll(){
//        val voucher = _vouchers.value
//        voucher?.forEach {
//            if(it.type ==1 && it.checked){
//                it.checked = !it.checked
//                count ++
//                sum += it.amountt
//                event?.clickItemSGD(sum)
//                event?.clickItem(count)
//            }
//        }
//
//    }
    fun updateAmountSelected(position: Int) {
        amountSelected.postValue(position)
    }

    fun updateSGDSelected(sum: Double) {
        sgdSelected.postValue(sum)
    }

    fun updateSelectedItem(isChecked: Boolean) {
        checked.postValue(isChecked)
    }
//
//    fun onClickItem(item: Item_Voucher) {
//        _event.value = Event(item)
//    }
}

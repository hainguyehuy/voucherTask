package com.example.firsttask.ui.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.example.firsttask.data.model.ItemVoucherSelectionState
import com.example.firsttask.data.model.ItemVoucherState
import com.example.firsttask.data.repository.RetrofitRepository
import kotlinx.coroutines.launch
import okhttp3.internal.applyConnectionSpec
import kotlin.coroutines.coroutineContext

class VoucherViewModel : ViewModel() {
    //    private val retrofitRepository = RetrofitRepository()
    val dataItem = ItemVoucherSelectionState(
        isLoading = false,
        paymentAmount = 0.0,
        displayItem = 3,
        totalCount = 3,
        selectCount = 2,
        data = listOf(
            ItemVoucherState(
                id = "0",
                name = "\$10 Min of spend \$80 second line",
                provider = "Plaza Prenium",
                status = ItemVoucherState.Status.Default,
                amount = 10.0
            ),
            ItemVoucherState(
                id = "1",
                name = "\$10 Min of spend \$80 second line",
                provider = "Plaza Prenium",
                status = ItemVoucherState.Status.Selected,
                amount = 10.0
            ),
            ItemVoucherState(
                id = "2",
                name = "\$10 Min of spend \$80 second line",
                provider = "Plaza Prenium",
                status = ItemVoucherState.Status.Default,
                amount = 5.0
            )
        )
    )
    val dataItem1 = ItemVoucherSelectionState(
        isLoading = false,
        paymentAmount = 0.0,
        displayItem = 3,
        totalCount = 3,
        selectCount = 3,
        data = listOf(
            ItemVoucherState(
                id = "0",
                name = "\$10 Min of spend \$80 second line",
                provider = "Plaza Prenium",
                status = ItemVoucherState.Status.Selected,
                amount = 10.0
            ),
            ItemVoucherState(
                id = "1",
                name = "\$10 Min of spend \$80 second line",
                provider = "Plaza Prenium",
                status = ItemVoucherState.Status.Selected,
                amount = 10.0
            ),
            ItemVoucherState(
                id = "2",
                name = "\$10 Min of spend \$80 second line",
                provider = "Plaza Prenium",
                status = ItemVoucherState.Status.Selected,
                amount = 5.0
            )
        )
    )
    private val _voucher: MutableLiveData<ItemVoucherSelectionState> = MutableLiveData(dataItem)
    var voucher: LiveData<ItemVoucherSelectionState> = _voucher

    @SuppressLint("SuspiciousIndentation")
    fun fetchVoucher() {
        viewModelScope.launch {
            _voucher.postValue(dataItem)
        }
    }

    fun onClickItem(itemVoucherState: ItemVoucherState) {
        var totalAmount = 0.0
        dataItem.data.forEach {
            if (itemVoucherState.status == ItemVoucherState.Status.Default) {
                itemVoucherState.status = ItemVoucherState.Status.Selected
            }
        }



        Log.d("data", totalAmount.toString())

//        if (itemVoucherState.status != ItemVoucherState.Status.Default){
//            var totalAmount = 0.0
//            dataItem1.data.forEach {
//                totalAmount =+ it.amount
//            }
//            Log.d("data",dataItem.data[1].name)
//        }
    }

}

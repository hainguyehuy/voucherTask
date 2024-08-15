package com.example.firsttask.ui.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.example.firsttask.data.model.ItemVoucherSelectionState
import com.example.firsttask.data.model.ItemVoucherState
import com.example.firsttask.data.repository.RetrofitRepository
import kotlinx.coroutines.launch

class VoucherViewModel : ViewModel() {
    private val retrofitRepository = RetrofitRepository()
    val data = ItemVoucherSelectionState(
        isLoading = false,
        paymentAmount = 0.0,
        totalVoucherAmount = 20.0,
        displayItem = 3,
        totalCount = 3,
        selectCount = 2,
        data = listOf(
            ItemVoucherState(
                id = "0",
                name = "\$10 Min of spend \$80 second line",
                provider = "Plaza Prenium",
                status = ItemVoucherState.Status.Selected,
                amount = 10.0
            ),
            ItemVoucherState(
                id = "0",
                name = "\$10 Min of spend \$80 second line",
                provider = "Plaza Prenium",
                status = ItemVoucherState.Status.Selected,
                amount = 10.0
            ),
            ItemVoucherState(
                id = "0",
                name = "\$10 Min of spend \$80 second line",
                provider = "Plaza Prenium",
                status = ItemVoucherState.Status.Default,
                amount = 10.0
            )
        )
    )
    val data1 = ItemVoucherSelectionState(
        isLoading = false,
        paymentAmount = 0.0,
        totalVoucherAmount = 30.0,
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
                id = "0",
                name = "\$10 Min of spend \$80 second line",
                provider = "Plaza Prenium",
                status = ItemVoucherState.Status.Selected,
                amount = 10.0
            ),
            ItemVoucherState(
                id = "0",
                name = "\$10 Min of spend \$80 second line",
                provider = "Plaza Prenium",
                status = ItemVoucherState.Status.Selected,
                amount = 10.0
            )
        )
    )

    @SuppressLint("SuspiciousIndentation")
    fun fetchVoucher() {
        viewModelScope.launch {

        }
    }
    fun onClick(itemVoucherState: ItemVoucherState) {

    }

}

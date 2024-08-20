package com.example.firsttask.ui.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firsttask.data.model.ItemVoucherSelectionState
import com.example.firsttask.data.model.ItemVoucherState
import com.example.firsttask.data.repository.RetrofitRepository
import kotlinx.coroutines.launch

class VoucherViewModel : ViewModel() {
    private val retrofitRepository = RetrofitRepository()
    private val dataItem = ItemVoucherSelectionState(
        isLoading = false,
        paymentAmount = 0.0,
        displayItem = 3,
        totalCount = 3,
        data = listOf(
            ItemVoucherState(
                id = "0",
                name = "\$10 Min of spend \$80 second line",
                provider = "Plaza Prenium",
                status = ItemVoucherState.Status.Default,
                amount = 10.0,
                type = 0
            ),
            ItemVoucherState(
                id = "3",
                name = "\$10 Min of spend \$80 second line",
                provider = "Plaza Prenium",
                status = ItemVoucherState.Status.Default,
                amount = 10.0,
                type = 1

            ),
            ItemVoucherState(
                id = "2",
                name = "\$10 Min of spend \$80 second line",
                provider = "Plaza Prenium",
                status = ItemVoucherState.Status.Default,
                amount = 5.0,
                type = 0

            )
        )
    )
    private val dataItem1 = ItemVoucherSelectionState(
        isLoading = false,
        paymentAmount = 0.0,
        displayItem = 3,
        totalCount = 3,
        data = listOf(
            ItemVoucherState(
                id = "0",
                name = "\$10 Min of spend \$80 second line",
                provider = "Plaza Prenium",
                status = ItemVoucherState.Status.Default,
                amount = 10.0,
                type = 1

            ),
            ItemVoucherState(
                id = "1",
                name = "\$10 Min of spend \$80 second line",
                provider = "Plaza Prenium",
                status = ItemVoucherState.Status.Selected,
                amount = 10.0,
                type = 0

            ),
            ItemVoucherState(
                id = "2",
                name = "\$10 Min of spend \$80 second line",
                provider = "Plaza Prenium",
                status = ItemVoucherState.Status.Default,
                amount = 5.0,
                type = 1

            )
        )
    )
    private val _voucher = MutableLiveData<ItemVoucherSelectionState>()
    var voucher: LiveData<ItemVoucherSelectionState> = _voucher

    @SuppressLint("SuspiciousIndentation")
    fun fetchVoucher() {
        viewModelScope.launch {
            _voucher.postValue(dataItem)
            _voucher.value!!.data.sortedBy {  it.type }
//            val response = retrofitRepository.getVouchers()
//            val newData = response.map { ItemVoucherState.mapItemVoucher(it) }
//
//            _voucher.postValue()

        }
    }

    fun onClickItem(itemVoucherState: ItemVoucherState) {
        /*
        lấy dữ liệu chuyển đổi từ MutableLiveData
        duyệt qua các phần tử trong data, nếu item.id = itemVoucherState.id
        cập nhật trạng thái của item đó
        thay thế phần tử có id trùng với id(click) vào trong ItemVoucherSelectionState.data
        cập nhật lại MutableLiveData<ItemVoucherSelectionState>
        */

        val itemVoucherStateNew = _voucher.value!!.data.map {
            if (it.id == itemVoucherState.id) {
                val nState =
                    if (it.status == ItemVoucherState.Status.Default) ItemVoucherState.Status.Selected else ItemVoucherState.Status.Default
                val newDataTest = it.copy(status = nState)
                newDataTest
            } else {
                it
            }
        }
        val rvData = dataItem.copy(data = itemVoucherStateNew)
        _voucher.postValue(rvData)


//        val data = itemVoucherState.copy(status = ItemVoucherState.Status.Selected)
        //Log.d("a", _voucher.)
        //th1
        //itemVoucherState.status == ItemVoucherState.Status.Default
        // default -> selected
        // selectCount = ItemVoucherState.Status.Selected
        // displayItem = dataItem.data.size
        // totalVoucherAmount += itemVoucherState.amount

        //th2
        //itemVoucherState.status == ItemVoucherState.Status.Selected
        // selected -> default
        // selectCount = ItemVoucherState.Status.Selected
        // displayItem = dataItem.data.size
        // totalVoucherAmount -= itemVoucherState.amount

        // th3 (chỉ đc chọn 1 voucher )
        // itemVoucherState.status == ItemVoucherState.Status.Disable
        // selectCount = 1
        // totalVoucherAmount = itemVoucherState.amount


        //
    }

    fun onClickAllItem() {
        val itemVoucherStateNew = _voucher.value!!.data.map {
            val nState =
                if (it.status == ItemVoucherState.Status.Default) ItemVoucherState.Status.Selected else ItemVoucherState.Status.Default
            val newDataTest = it.copy(status = nState)
            newDataTest
        }
        val rvData = _voucher.value!!.copy(data = itemVoucherStateNew)
        _voucher.postValue(rvData)
    }

}


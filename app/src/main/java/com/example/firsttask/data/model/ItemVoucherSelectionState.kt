package com.example.firsttask.data.model

import androidx.fragment.app.viewModels
import com.example.firsttask.ui.viewmodel.VoucherViewModel
import java.io.Serializable

class ItemVoucherSelectionState(
    var isLoading: Boolean = false,
    var paymentAmount: Double = 0.0,
    var totalVoucherAmount: Double = 0.0,
    var displayItem: Int = 3,
    var totalCount: Int = 0,
    var selectCount: Int = 0,
    val data: List<ItemVoucherState> = mutableListOf()

) : Serializable {

    fun total(): Double {

        data.forEach {
            if (it.status == ItemVoucherState.Status.Selected) {
                totalVoucherAmount += it.amount
            }
        }
        return totalVoucherAmount
    }

    val selectedVoucher
        get() = data.count {
            it.status == ItemVoucherState.Status.Selected
        }

    val selectedOrUnselectedItem
        get() = if (selectedVoucher == data.size) {
            "UnSelected all "
        } else {
            "Selected All ${data.size} "
        }


}
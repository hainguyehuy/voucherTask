package com.example.firsttask.data.model

import java.io.Serializable

data class ItemVoucherSelectionState(
    var isLoading: Boolean = false,
    var paymentAmount: Double = 0.0,
    var displayItem: Int = 0,
    var totalCount: Int = 0,
    val data: List<ItemVoucherState> = mutableListOf()

) : Serializable {

    private fun totalVouchersAmount(): Double {
        var totalVouchersAmount = 0.0
        data.forEach {
            if (it.status == ItemVoucherState.Status.Selected) {
                totalVouchersAmount += it.amount
            }
        }
        return totalVouchersAmount
    }
    val totalVouchersAmount : Double get() = totalVouchersAmount()

    val displayItemUI : Int get() = data.size

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
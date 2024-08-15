package com.example.firsttask.data.model

import java.io.Serializable

class ItemVoucherSelectionState(
    var isLoading: Boolean = false,
    var paymentAmount: Double = 0.0,
    var totalVoucherAmount: Double = 0.0,
    var displayItem: Int = 3,
    var totalCount: Int = 0,
    var selectCount: Int = 0,
    val data: List<ItemVoucherState> = mutableListOf(
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

) : Serializable {
    //    val total get() = data.forEach {
//        totalVoucherAmount += it.amount
//    }
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
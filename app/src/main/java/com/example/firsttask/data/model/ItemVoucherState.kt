package com.example.firsttask.data.model

import com.example.firsttask.R

data class ItemVoucherState(
    val id: String,
    val amount: Double,
//    val image : Uri,
    val provider: String,
    val name: String,
    var status : Status = Status.Default,
//    val type : Boolean,
//    val rawData: Item

) {
    enum class Status() {
        Default(),
        Selected(),
        Disable();
    }

    companion object {
        fun mapItemVoucher(rawData: Item): ItemVoucherState = ItemVoucherState(
            id = rawData.id.toString(),
            amount = rawData.amount.toDouble(),
            name = rawData.name,
            provider = rawData.provider,
//            rawData = rawData
        )
    }
}

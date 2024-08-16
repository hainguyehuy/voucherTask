package com.example.firsttask.data.model

import com.example.firsttask.R

class ItemVoucherState(
    val id: String,
    val amount: Double,
//    val image : Uri,
    val provider: String,
    val name: String,
    val status : Status = Status.Default,
//    val type : Boolean,
//    val rawData: Item

) {
    enum class Status(plus: Int) {
        Default(R.drawable.plus),
        Selected(R.drawable.quantity),
        Disable(R.drawable.plusgray);
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

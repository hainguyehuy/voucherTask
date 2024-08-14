package com.example.firsttask.data.model

import android.graphics.drawable.Drawable
import android.net.Uri

class ItemVoucherState(
    val id: String,
    val amount: Double,
//    val image : Uri,
    val provider: String,
    val name: String,
//    val status : Status = Status.Default,
//    val type : Boolean,
    val rawData: Item

) {
    enum class Status {
        Default,
        Selected,
        Disable;

        fun selectionStatus() = this
    }

    companion object {
        val status = Status.Default

        fun mapItemVoucher(rawData: Item): ItemVoucherState = ItemVoucherState(
            id = rawData.id.toString(),
            amount = rawData.amount.toDouble(),
            name = rawData.name,
            provider = rawData.provider,
            rawData = rawData
        )
    }
}

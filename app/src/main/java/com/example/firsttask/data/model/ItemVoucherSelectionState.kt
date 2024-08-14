package com.example.firsttask.data.model

import java.io.Serializable

class ItemVoucherSelectionState(
    val isLoading : Boolean = false,
    val paymentAmount : Double = 0.0,
    val totalVoucherAmount : Double = 0.0,
    val totalCount : Int = 0,
    val data : List<ItemVoucherState> = mutableListOf()

) : Serializable {

}
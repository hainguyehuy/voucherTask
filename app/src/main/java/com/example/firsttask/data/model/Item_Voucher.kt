package com.example.firsttask.data.model


data class Item_Voucher(
    var amountt : Double,
    var provider: String,
    var exp : String,
    var checked : Boolean = false,
    val name: String,
    val minSpend: String,
    val id: Int,
    val type : Int

) {

}
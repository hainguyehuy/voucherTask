package com.example.firsttask.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.firsttask.R
import com.example.firsttask.data.model.ItemVoucherState
import com.example.firsttask.data.model.Item_Voucher
import com.example.firsttask.databinding.ItemLayoutBinding
import com.example.firsttask.ui.view.ButtonClickEvent

class ItemVoucherAdapter(private val onClickItem : (ItemVoucherState) -> Unit) :
    RecyclerView.Adapter<ItemVoucherAdapter.ItemVoucherAdapterViewHolder>() {


    private val list = ArrayList<ItemVoucherState>()
    @SuppressLint("NotifyDataSetChanged")
    fun updateItemData(items: List<ItemVoucherState>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    var event: ButtonClickEvent? = null
    var count = 0
    var sum = 0.0
    var minus = 0.0
    var minusSelected = 0

    override fun onBindViewHolder(holder: ItemVoucherAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemVoucherAdapterViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemVoucherAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ItemVoucherAdapterViewHolder(private var binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemVoucherState) {
            binding.tvNameVoucher.text = item.name
            binding.tvEXP.text = item.amount.toString()
            binding.tvProvider.text = item.provider

            binding.root.setOnClickListener {
                onClickItem(list[adapterPosition])
            }
            // bỏ comment từng dòng bên dưới, rồi chạy lại để xem kết quả

//            th 1. ivPlus: disable
            binding.ivPlus.isActivated = false
            binding.ivPlus.isEnabled = false
//
////          th 2. ivPlus: select = no
//            binding.ivPlus.isActivated = false
//            binding.ivPlus.isEnabled = true

////          th 3. ivPlus: select = yet
//            binding.ivPlus.isActivated = true
//            binding.ivPlus.isEnabled = true
        }
    }
}
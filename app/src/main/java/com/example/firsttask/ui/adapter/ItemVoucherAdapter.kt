package com.example.firsttask.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.firsttask.data.model.Item
import com.example.firsttask.data.model.Item_voucher
import com.example.firsttask.databinding.ItemLayoutBinding

class ItemVoucherAdapter(): RecyclerView.Adapter<ItemVoucherAdapter.ItemVoucherAdapterViewHolder>() {
    private val item = ArrayList<Item_voucher>()
    private val count = null
    inner class ItemVoucherAdapterViewHolder(private var binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Item_voucher){
            binding.tvNameVoucher.text = item.amount
            binding.imgVoucher.setOnClickListener {
                for(i in 1..itemCount){
                    if(item.checked){
                        //
                    }
            }
                //updateItemView ( check value nguoc lai cua + )
                // use forEach ItemView ( tao 1 bien dem, va truyen vao clickItem khi dem xong
            }
        }
    }
    fun updateItemData(items: List<Item_voucher>) {
        item.clear()
        item.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemVoucherAdapterViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemVoucherAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ItemVoucherAdapterViewHolder, position: Int) {
        holder.bind(item[position])
    }
}
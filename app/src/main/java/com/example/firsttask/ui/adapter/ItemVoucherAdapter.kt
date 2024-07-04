package com.example.firsttask.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firsttask.R
import com.example.firsttask.data.model.Item_Voucher
import com.example.firsttask.databinding.ItemLayoutBinding
import com.example.firsttask.ui.view.ButtonClickEvent

class ItemVoucherAdapter() :
    RecyclerView.Adapter<ItemVoucherAdapter.ItemVoucherAdapterViewHolder>() {
    private val item = ArrayList<Item_Voucher>()
    fun updateItemData(items: List<Item_Voucher>) {
        item.clear()
        item.addAll(items)
        notifyDataSetChanged()
    }

    var event: ButtonClickEvent? = null
    var count = 0
    var sum = 0.0
    val isCheck = true

    inner class ItemVoucherAdapterViewHolder(private var binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item_Voucher) {
            binding.tvNameVoucher.text = item.name
            binding.tvEXP.text = item.exp
            binding.tvProvider.text = item.provider
            binding.imgPlus.setOnClickListener {
                count += 1
                sum += item.amountt
                if (item.checked) {
                    event!!.clickItem(count)
                    event!!.clickItemSGD(sum)
                    binding.imgPlus.setImageResource(R.drawable.quantity)
                    binding.imgPlus.isEnabled
                }

            }

        }
    }

    override fun onBindViewHolder(holder: ItemVoucherAdapterViewHolder, position: Int) {
        holder.bind(item[position])

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

    fun clickSelectedAll(select: Boolean) {
        item.forEach {
            it.checked = select
            notifyDataSetChanged()

        }
    }

}
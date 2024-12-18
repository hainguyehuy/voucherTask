package com.example.firsttask.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firsttask.data.model.ItemVoucherState
import com.example.firsttask.databinding.ItemLayoutBinding

class ItemVoucherAdapter(private val onClickItem: (ItemVoucherState) -> Unit) :
    RecyclerView.Adapter<ItemVoucherAdapter.ItemVoucherAdapterViewHolder>() {


    private val list = ArrayList<ItemVoucherState>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateItemData(items: List<ItemVoucherState>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }



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
                onClickItem(item)
            }

            when (item.status) {
                ItemVoucherState.Status.Disable -> {
                    binding.ivPlus.isActivated = false
                    binding.ivPlus.isEnabled = false
                }

                ItemVoucherState.Status.Default -> {
                    binding.ivPlus.isActivated = false
                    binding.ivPlus.isEnabled = true
                }

                ItemVoucherState.Status.Selected -> {
                    binding.ivPlus.isActivated = true
                    binding.ivPlus.isEnabled = true
                }
            }


        }
    }
}
package com.example.firsttask.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firsttask.data.model.Item
import com.example.firsttask.databinding.ItemLayoutBinding

class VoucherAdapter(private val item : List<Item>) : RecyclerView.Adapter<VoucherAdapter.VoucherViewHolder>(){
    class VoucherViewHolder(private var binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Item){
            binding.tvNameVoucher.text = item.name
            binding.tvProvider.text = item.provider
            binding.tvDate.text = item.exp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoucherViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VoucherViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: VoucherViewHolder, position: Int) {
        holder.bind(item[position])
    }
}
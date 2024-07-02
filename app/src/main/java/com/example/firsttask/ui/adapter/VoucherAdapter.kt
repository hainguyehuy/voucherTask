package com.example.firsttask.ui.adapter
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firsttask.data.model.Item
import com.example.firsttask.databinding.ItemLayoutBinding
import com.example.firsttask.ui.view.ButtonClickEvent

class VoucherAdapter() : RecyclerView.Adapter<VoucherAdapter.VoucherViewHolder>(){
    //khai bao interface
    var event : ButtonClickEvent?= null
    var count = 0
    var sum = 0.0
    private val item : MutableList<Item> = mutableListOf()
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<Item>) {
        item.clear()
        item.addAll(items)
        notifyDataSetChanged()
    }

    inner class VoucherViewHolder(private var binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        @SuppressLint("ResourceType")
        fun bind(item : Item){
//            binding.tvNameVoucher.text = item.amount
//            binding.imgPlus.setOnClickListener {
//                count ++
//                sum+=item.amount.toDouble()
//                for(i in 1..itemCount){
//                    event!!.clickItem(count)
//                    event!!.clickItemSGD(sum)
//                    binding.imgPlus.setImageResource(R.drawable.img_1)
//                }
//            }
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
package com.example.firsttask.ui.adapter
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.media3.common.util.Util
import androidx.recyclerview.widget.RecyclerView
import com.example.firsttask.data.model.Item
import com.example.firsttask.databinding.ItemLayoutBinding
import com.example.firsttask.ui.view.ButtonClickEvent

class VoucherAdapter() : RecyclerView.Adapter<VoucherAdapter.VoucherViewHolder>(){
    //khai bao interface
    var event : ButtonClickEvent?= null
    private val item : MutableList<Item> = mutableListOf()
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<Item>) {
        item.clear()
        item.addAll(items)
        notifyDataSetChanged()
    }

    inner class VoucherViewHolder(private var binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Item){
            binding.tvNameVoucher.text = item.name
            binding.tvProvider.text = item.provider
            binding.tvDate.text = item.exp
            binding.imgPlus.setOnClickListener {
                event!!.clickItem(5)
                //updateItemView ( check value nguoc lai cua + )
                // use forEach ItemView ( tao 1 bien dem, va truyen vao clickItem khi dem xong
            }
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
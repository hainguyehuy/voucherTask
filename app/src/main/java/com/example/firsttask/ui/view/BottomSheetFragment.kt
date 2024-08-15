package com.example.firsttask.ui.view

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsttask.R
import com.example.firsttask.data.model.ItemVoucherSelectionState
import com.example.firsttask.data.model.ItemVoucherState
import com.example.firsttask.data.model.Item_Voucher
import com.example.firsttask.data.model.voucherX
import com.example.firsttask.databinding.FragmentBottomSheetBinding
import com.example.firsttask.ui.adapter.ItemVoucherAdapter
import com.example.firsttask.ui.viewmodel.VoucherViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

//

class BottomSheetFragment : BottomSheetDialogFragment(){
    private var _binding: FragmentBottomSheetBinding? = null
    private val binding get() = _binding!!
    private val itemVoucherAdapter = ItemVoucherAdapter(::onClickItem)
    private val viewModel: VoucherViewModel by viewModels()
    private val itemVoucherSelectionState = ItemVoucherSelectionState()



    private fun onClickItem(itemVoucherState: ItemVoucherState) {
        viewModel.onClick(itemVoucherState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        _binding!!.rvVoucher.layoutManager = LinearLayoutManager(context)
        _binding!!.rvVoucher.adapter = itemVoucherAdapter

        _binding!!.rightIcon.setOnClickListener {
            val message: String? = "Do you want to apply your selected vouchers"
            showsCustomDialogBox(message)
        }
        viewModel.fetchVoucher()



        return binding.root

    }
    private fun showsCustomDialogBox(message: String?) {
        val dialog = context?.let { Dialog(it) }
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(false)
        dialog?.setContentView(R.layout.custom_dialog)
        val apply: TextView? = dialog?.findViewById(R.id.tvApply)
        val dontApply: TextView? = dialog?.findViewById(R.id.tvDontApply)

        apply?.setOnClickListener {
            Toast.makeText(context, "Apply Vouchers Completed", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }
        dontApply?.setOnClickListener {
            dialog.dismiss()
            dismiss()
        }
        dialog?.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}
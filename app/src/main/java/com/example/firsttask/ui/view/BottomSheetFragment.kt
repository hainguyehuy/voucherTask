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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsttask.R
import com.example.firsttask.data.model.Item_Voucher
import com.example.firsttask.data.model.voucherX
import com.example.firsttask.databinding.FragmentBottomSheetBinding
import com.example.firsttask.ui.adapter.ItemVoucherAdapter
import com.example.firsttask.ui.viewmodel.VoucherViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

interface ButtonClickEvent {
    fun clickItem(count: Int)
    fun clickItemSGD(sum: Double)
    fun clickSelectAll(isChecked: Boolean)
}

class BottomSheetFragment : BottomSheetDialogFragment(), ButtonClickEvent {
    private val viewModel: VoucherViewModel by viewModels()
    private var _binding: FragmentBottomSheetBinding? = null
    private val itemVoucherAdapter = ItemVoucherAdapter()
    private val voucherList = ArrayList<Item_Voucher>()

    //    private val listVoucher = ArrayList<Item_Voucher>()
    private val binding get() = _binding!!
    val select = "Select all"
    val display = "Displaying"
    val unSelect = "UnSelect all "

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        _binding!!.rvVoucher.layoutManager = LinearLayoutManager(context)



        _binding!!.rvVoucher.adapter = itemVoucherAdapter
        itemVoucherAdapter.updateItemData(voucherList)


        //handle selectAll
        _binding!!.tvSelectedAllVoucher.setOnClickListener {
            val isCorrect = checkCondition()
            viewModel.vouchers.observe(this) {
                _binding!!.tvSelectedAllVoucher.text = if (isCorrect) {
                    StringBuilder().append(unSelect).append(" ").append(it.size.toString())
                } else {
                    StringBuilder().append(select).append(" ").append(it.size.toString())
                }
            }
        }
        //handle event click X icon
        _binding!!.rightIcon.setOnClickListener {
            val message: String? = "Do you want to apply your selected vouchers"
            showsCustomDialogBox(message)
        }

        viewModel.vouchers.observe(this) {
            _binding!!.tvSelectedAllVoucher.text =
                StringBuilder().append(select).append(" ").append(it.size.toString())
            _binding!!.tvDisplayVouchers.text =
                StringBuilder().append(display).append(" ").append(it.size.toString())
                    .append(" of ${it.size} vouchers")
            itemVoucherAdapter.updateItemData(it)
        }
        viewModel.fetchVoucher()


        itemVoucherAdapter.event = this
        viewModel.amountSelected.observe(this) {
            _binding!!.tvSelected.text =
                StringBuilder().append("Selected vouchers " + "(${it})")
            _binding!!.tvSelectedAllVoucher.text =
                StringBuilder().append(unSelect).append(" (${it})")
        }
        viewModel.sgdSelected.observe(this) {
            _binding!!.tvSGD.text = StringBuilder().append("SGD " + "${it.toDouble()}")
        }
        viewModel.checked.observe(this) {
            _binding!!.tvSelectedAllVoucher.text = it.toString()
        }

        return binding.root

    }

    private fun checkCondition(): Boolean {
        var result: Boolean = true
        if (result) {
            itemVoucherAdapter.clickSelectedAll(true)

        } else {
            itemVoucherAdapter.changeUnselect(true)
        }
        return result
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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun clickItem(count: Int) {
        viewModel.updateAmountSelected(count)
    }

    override fun clickItemSGD(sum: Double) {
        viewModel.updateSGDSelected(sum)

    }

    override fun clickSelectAll(isChecked: Boolean) {
        viewModel.updateSelectedItem(isChecked)
    }


}
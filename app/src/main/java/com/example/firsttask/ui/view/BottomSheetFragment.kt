package com.example.firsttask.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsttask.databinding.FragmentBottomSheetBinding
import com.example.firsttask.ui.adapter.VoucherAdapter
import com.example.firsttask.ui.viewmodel.VoucherViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

interface ButtonClickEvent{
    fun clickItem(count : Int)

}
class BottomSheetFragment : BottomSheetDialogFragment(), ButtonClickEvent {
    private val viewModel: VoucherViewModel by viewModels()
    private var _binding: FragmentBottomSheetBinding? = null
    private val voucherAdapter = VoucherAdapter()
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        _binding!!.rvVoucher.layoutManager = LinearLayoutManager(context)
        _binding!!.rvVoucher.adapter = voucherAdapter
        viewModel.vouchers.observe(this) {
            voucherAdapter.updateData(it)
        }
        viewModel.fetchVoucher()

        //set interface = interface implement in this class
        voucherAdapter.event = this
        viewModel.amountSelected.observe(this){
            _binding!!.tvSelected.text = it.toString()
        }
        return binding.root

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

}
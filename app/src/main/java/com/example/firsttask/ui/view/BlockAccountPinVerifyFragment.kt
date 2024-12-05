package com.example.firsttask.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firsttask.R
import com.example.firsttask.databinding.FragmentBlockAccountPinVerifyBinding


class BlockAccountPinVerifyFragment : Fragment() {
    private var _binding : FragmentBlockAccountPinVerifyBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlockAccountPinVerifyBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.lpBtnBlockAccount?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView,BlockAccountResultFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
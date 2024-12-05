package com.example.firsttask.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firsttask.R
import com.example.firsttask.databinding.ActivityBlockAccountBinding

class BlockAccountActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBlockAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlockAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView,BlockAccountFragment())
                .addToBackStack(null)
                .commit()
        }

    }
}
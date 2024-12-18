package com.example.firsttask.ui.view

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.firsttask.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.btn)
        btn.setOnClickListener {
                val bottomSheetFragment = BottomSheetFragment()
                bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
            }
    }
}

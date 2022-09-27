package com.example.currencyrateproject.view.main_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.currencyrateproject.R
import com.example.currencyrateproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
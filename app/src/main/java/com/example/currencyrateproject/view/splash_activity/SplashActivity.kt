package com.example.currencyrateproject.view.splash_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.currencyrateproject.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
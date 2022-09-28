package com.example.currencyrateproject.view.main_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.currencyrateproject.R
import com.example.currencyrateproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val FRAGMENTS_AMOUNT = 2
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewPager.adapter = MainViewPagerAdapter(this)

        setContentView(binding.root)
    }
}
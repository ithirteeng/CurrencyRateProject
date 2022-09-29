package com.example.currencyrateproject.view.main_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyrateproject.R
import com.example.currencyrateproject.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

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
        binding.tabLayout.tabIconTint = null
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            run {
                when (position) {
                    0 -> {
                        tab.setIcon(R.drawable.icon_cash)
                        tab.text = resources.getString(R.string.cash_tab_text)
                    }
                    1 -> {
                        tab.setIcon(R.drawable.icon_search)
                        tab.text = resources.getString(R.string.query_tab_cash)
                    }
                }
            }
        }.attach()
        setContentView(binding.root)
    }
}
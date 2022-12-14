package com.example.currencyrateproject.presentation.main_activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.currencyrateproject.presentation.main_activity.cash_fragment.CashFragment
import com.example.currencyrateproject.presentation.main_activity.query_fragment.QueryFragment

class MainViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return MainActivity.FRAGMENTS_AMOUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> CashFragment()
            else -> QueryFragment()
        }
    }

}
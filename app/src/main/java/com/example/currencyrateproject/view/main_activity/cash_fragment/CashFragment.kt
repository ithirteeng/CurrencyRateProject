package com.example.currencyrateproject.view.main_activity.cash_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyrateproject.R
import com.example.currencyrateproject.databinding.FragmentCashBinding
import com.example.currencyrateproject.view.model.Item

class CashFragment : Fragment() {

    private lateinit var binding: FragmentCashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this)[CashFragmentViewModel::class.java]
        val mainView = inflater.inflate(R.layout.fragment_cash, container, false)

        binding = FragmentCashBinding.bind(mainView)

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this.context)

        val liveData = viewModel.getLiveData()

        liveData.observe(viewLifecycleOwner) { list ->
            val cashAdapter = CashAdapter()
            cashAdapter.setList(list as ArrayList<Item>)
            recyclerView.adapter = cashAdapter
        }

        return mainView
    }

}
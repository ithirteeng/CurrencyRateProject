package com.example.currencyrateproject.view.main_activity.cash_fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyrateproject.R
import com.example.currencyrateproject.databinding.FragmentCashBinding
import com.example.currencyrateproject.view.model.Item

class CashFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CashAdapter

    private lateinit var binding: FragmentCashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this)[CashFragmentViewModel::class.java]
        val view = inflater.inflate(R.layout.fragment_cash, container, false)

        binding = FragmentCashBinding.bind(view)

        recyclerView = binding.recyclerView
        adapter = CashAdapter()

        recyclerView.adapter = adapter

        val liveData = viewModel.getLiveData()

        liveData.observe(viewLifecycleOwner) { list ->
            adapter.setList(list as ArrayList<Item>)
        }
        Log.d("SSTAG", liveData.value.toString())
        return view
    }

}
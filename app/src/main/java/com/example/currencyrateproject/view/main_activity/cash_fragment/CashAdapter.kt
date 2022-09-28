package com.example.currencyrateproject.view.main_activity.cash_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyrateproject.databinding.ItemExchangeLayoutBinding
import com.example.currencyrateproject.view.model.Item

class CashAdapter : RecyclerView.Adapter<CashAdapter.CashViewHolder>() {


    class CashViewHolder(private val binding: ItemExchangeLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.currencyNameTextView.text = item.name
            binding.priceTextView.text = item.sellPrice.toString()
        }
    }


    private val viewModel by lazy {
        CashFragmentViewModel()
    }


    private val itemList = viewModel.getItemList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CashViewHolder {
        val binding = ItemExchangeLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CashViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CashViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
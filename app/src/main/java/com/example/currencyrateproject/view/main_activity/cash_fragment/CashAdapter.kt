package com.example.currencyrateproject.view.main_activity.cash_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyrateproject.R
import com.example.currencyrateproject.databinding.ItemExchangeLayoutBinding
import com.example.currencyrateproject.view.model.Item

class CashAdapter : RecyclerView.Adapter<CashAdapter.CashViewHolder>() {

    class CashViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemExchangeLayoutBinding.bind(view)

        fun bind(item: Item) {
            binding.currencyNameTextView.text = item.name
            binding.priceTextView.text = item.sellPrice.toString()
        }
    }

    private var itemList = emptyList<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CashViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_exchange_layout, parent, false)
        return CashViewHolder(view)
    }

    override fun onBindViewHolder(holder: CashViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setList(list: List<Item>) {
        itemList = list
    }
}
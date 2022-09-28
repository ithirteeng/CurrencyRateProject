package com.example.currencyrateproject.view.main_activity.cash_fragment

import androidx.lifecycle.ViewModel
import com.example.currencyrateproject.data.repository.CurrencyRepositoryImpl
import com.example.currencyrateproject.domain.model.Valute
import com.example.currencyrateproject.domain.use_case.GetDataUseCase
import com.example.currencyrateproject.view.model.Item

class CashFragmentViewModel : ViewModel() {

    private val currencyRepositoryImpl by lazy {
        CurrencyRepositoryImpl()
    }
    private val getDataUseCase by lazy {
        GetDataUseCase(currencyRepositoryImpl)
    }

    fun getItemList(): List<Item> {
        val valuteList = getDataUseCase.execute()
        val itemMutableList = mutableListOf<Item>()
        for (valute in valuteList) {
            itemMutableList.add(translateValuteToItem(valute))
        }
        return itemMutableList.toList()
    }

    private fun translateValuteToItem(valute: Valute): Item {
        return Item(valute.charCode, valute.value / valute.nominal)
    }

}
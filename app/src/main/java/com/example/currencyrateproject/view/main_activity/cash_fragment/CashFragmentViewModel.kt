package com.example.currencyrateproject.view.main_activity.cash_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyrateproject.data.repository.CurrencyRepositoryImpl
import com.example.currencyrateproject.domain.model.Valute
import com.example.currencyrateproject.domain.use_case.GetDataUseCase
import com.example.currencyrateproject.view.model.Item
import kotlinx.coroutines.launch

class CashFragmentViewModel : ViewModel() {

    private val currencyRepositoryImpl by lazy {
        CurrencyRepositoryImpl()
    }
    private val getDataUseCase by lazy {
        GetDataUseCase(currencyRepositoryImpl)
    }

    private val itemList = MutableLiveData<List<Item>>()

    fun getLiveData(): MutableLiveData<List<Item>> {
        return itemList
    }

    fun createItemList() {
        val currentValuteList = getValuteList()
        val currentItemList = mutableListOf<Item>()
        for (valute in currentValuteList) {
            currentItemList.add(translateValuteToItem(valute))
        }
        itemList.value = currentItemList
    }

    private fun getValuteList(): List<Valute> {
        var valuteList = listOf<Valute>()
        viewModelScope.launch {
           valuteList = getDataUseCase.execute()
        }
        return valuteList
    }

    private fun translateValuteToItem(valute: Valute): Item {
        return Item(valute.charCode, valute.value / valute.nominal)
    }

}
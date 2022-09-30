package com.example.currencyrateproject.presentation.main_activity.cash_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyrateproject.data.repository.CurrencyRepositoryImpl
import com.example.currencyrateproject.domain.model.Valute
import com.example.currencyrateproject.domain.use_case.GetDataUseCase
import com.example.currencyrateproject.presentation.model.Item
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
        viewModelScope.launch {
            createItemList()
        }
        return itemList
    }

    private suspend fun createItemList() {
        val currentValuteList = getValuteList()
        val currentItemList = mutableListOf<Item>()
        for (valute in currentValuteList) {
            currentItemList.add(translateValuteToItem(valute))
        }
        itemList.value = currentItemList

    }

    private suspend fun getValuteList(): ArrayList<Valute> {
        return getDataUseCase.execute()
    }


    private fun translateValuteToItem(valute: Valute): Item {
        val quantity = valute.nominal.toDouble()
        val valueString = valute.value.replace(",", ".")
        val value = valueString.toDouble()
        val result = value / quantity
        return Item(valute.name, valute.charCode, result)
    }

}
package com.example.currencyrateproject.view.main_activity.cash_fragment

import android.util.Log
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
        Log.d("SSTAG", "SSDsd")
    }

    private suspend fun getValuteList(): ArrayList<Valute> {
        return getDataUseCase.execute()
    }



    private fun translateValuteToItem(valute: Valute): Item {
        return Item(valute.charCode, 234.0)
    }

}
package com.example.currencyrateproject.domain.use_case

import com.example.currencyrateproject.domain.model.Valute
import com.example.currencyrateproject.domain.repository.CurrencyRepository

class GetDataUseCase(private val currencyRepository: CurrencyRepository) {
    suspend fun execute(): ArrayList<Valute> {
        return currencyRepository.getCurrencyData().body()!!.valuteList
    }
}
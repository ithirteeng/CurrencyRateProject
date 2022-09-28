package com.example.currencyrateproject.domain.use_case

import com.example.currencyrateproject.domain.model.Valute
import com.example.currencyrateproject.domain.repository.CurrencyRepository

class GetDataUseCase(private val currencyRepository: CurrencyRepository) {
    fun execute(): List<Valute> {
        return currencyRepository.getCurrencyData().valuteList
    }
}
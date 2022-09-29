package com.example.currencyrateproject.domain.use_case

import com.example.currencyrateproject.domain.model.ValCurs
import com.example.currencyrateproject.domain.model.Valute
import com.example.currencyrateproject.domain.repository.CurrencyRepository
import retrofit2.Response

class GetDataUseCase(private val currencyRepository: CurrencyRepository) {
    suspend fun execute(): List<Valute> {
        return currencyRepository.getCurrencyData().body()!!.valuteList
    }
}
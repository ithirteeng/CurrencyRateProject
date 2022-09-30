package com.example.currencyrateproject.data.repository

import com.example.currencyrateproject.data.api.NetworkService
import com.example.currencyrateproject.domain.model.ValCurs
import com.example.currencyrateproject.domain.repository.CurrencyRepository
import retrofit2.Response

class CurrencyRepositoryImpl : CurrencyRepository {
    override suspend fun getCurrencyData(): Response<ValCurs> {
        return NetworkService.apiService.getMoneyStats()
    }
}
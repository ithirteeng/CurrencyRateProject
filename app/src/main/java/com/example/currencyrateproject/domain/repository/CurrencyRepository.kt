package com.example.currencyrateproject.domain.repository

import com.example.currencyrateproject.domain.model.ValCurs
import com.example.currencyrateproject.domain.model.Valute
import retrofit2.Response

interface CurrencyRepository {
    suspend fun getCurrencyData(): Response<ValCurs>
}
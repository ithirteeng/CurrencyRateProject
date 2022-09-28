package com.example.currencyrateproject.domain.repository

import com.example.currencyrateproject.domain.model.ValCurs

interface CurrencyRepository {
    fun getCurrencyData(): ValCurs
}
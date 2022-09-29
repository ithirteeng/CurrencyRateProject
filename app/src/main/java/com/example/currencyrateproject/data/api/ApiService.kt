package com.example.currencyrateproject.data.api

import com.example.currencyrateproject.domain.model.ValCurs
import com.example.currencyrateproject.domain.model.Valute
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    companion object {
        const val BASE_URL = "https://www.cbr-xml-daily.ru/"
    }

    @GET("daily.xml")
    suspend fun getMoneyStats(): Response<ValCurs>

}
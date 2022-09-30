package com.example.currencyrateproject.data.api

import com.example.currencyrateproject.domain.model.ValCurs
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    companion object {
        const val BASE_URL = "https://www.cbr-xml-daily.ru/"
    }

    @GET("daily_eng_utf8.xml")
    suspend fun getMoneyStats(): Response<ValCurs>

}
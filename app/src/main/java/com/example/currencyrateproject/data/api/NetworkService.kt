package com.example.currencyrateproject.data.api

import retrofit2.Retrofit
import retrofit2.converter.jaxb.JaxbConverterFactory
import retrofit2.create

object NetworkService {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .addConverterFactory(JaxbConverterFactory.create())
            .build()
    }
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
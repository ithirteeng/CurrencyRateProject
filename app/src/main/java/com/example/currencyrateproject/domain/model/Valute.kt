package com.example.currencyrateproject.domain.model

data class Valute(
    val id: String,
    val name: String,
    val value: Double,
    val charCode: String,
    val numCode: String,
    val nominal: Int
)

package com.example.currencyrateproject.domain.model

data class ValCurs(
    val date: String,
    val name: String,
    val valuteList: List<Valute>
)

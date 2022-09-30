package com.example.currencyrateproject.domain.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Valute")
data class Valute(
    @field:Attribute(name = "ID")
    var id: String = "",
    @field:Element(name = "NumCode")
    var numCode: String = "",
    @field:Element(name = "CharCode")
    var charCode: String = "",
    @field:Element(name = "Nominal")
    var nominal: String = "",
    @field:Element(name = "Name")
    var name: String = "",
    @field:Element(name = "Value")
    var value: String = ""

)

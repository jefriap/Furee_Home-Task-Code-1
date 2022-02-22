package com.jefriap.hometestcode.ui.getstarted

data class GetStartedData(
    val title: String,
    val description: String
)

val getStartedList = listOf(
    GetStartedData(
        "Find your best outfit and look great",
        "Shop here and get benefits and world quality goods"
    ),
    GetStartedData(
        "The power of clothing",
        "Take initiatives to change our collective future"
    ),
    GetStartedData(
        "About LifeWear",
        "LifeWear is clothing designed to improve everyone's life."
    )
)
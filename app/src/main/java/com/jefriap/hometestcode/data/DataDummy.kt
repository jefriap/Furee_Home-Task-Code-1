package com.jefriap.hometestcode.data

import com.jefriap.hometestcode.R

class DataDummy {
    fun getAllData(): List<ClothesData> {
        return listOf(
            ClothesData(
                id = 0,
                productName = "Kemeja Linen Blend Kerah",
                productDescription = R.string.lorem_ipsum,
                price = 699900,
                imageProduct = listOf(
                    R.drawable.img1,
                    R.drawable.img2,
                    R.drawable.img3
                )
            ),
            ClothesData(
                id = 1,
                productName = "AIRism Jaket Mesh Hoodie UV Protection",
                productDescription = R.string.lorem_ipsum,
                price = 429900,
                imageProduct = listOf(
                    R.drawable.img4,
                    R.drawable.img5,
                    R.drawable.img6
                )
            ),
            ClothesData(
                id = 2,
                productName = "Celana Smart Ankle 2WAY Stretch",
                productDescription = R.string.lorem_ipsum,
                price = 479900,
                imageProduct = listOf(
                    R.drawable.img7,
                    R.drawable.img8,
                    R.drawable.img9
                )
            ),
            ClothesData(
                id = 3,
                productName = "Kemeja Linen Blend Kerah",
                productDescription = R.string.lorem_ipsum,
                price = 699900,
                imageProduct = listOf(
                    R.drawable.img1,
                    R.drawable.img2,
                    R.drawable.img3
                )
            ),
            ClothesData(
                id = 4,
                productName = "AIRism Jaket Mesh Hoodie UV Protection",
                productDescription = R.string.lorem_ipsum,
                price = 429900,
                imageProduct = listOf(
                    R.drawable.img4,
                    R.drawable.img5,
                    R.drawable.img6
                )
            ),
            ClothesData(
                id = 5,
                productName = "Celana Smart Ankle 2WAY Stretch",
                productDescription = R.string.lorem_ipsum,
                price = 479900,
                imageProduct = listOf(
                    R.drawable.img7,
                    R.drawable.img8,
                    R.drawable.img9
                )
            )
        )
    }
}
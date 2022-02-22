package com.jefriap.hometestcode.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ClothesData(
    val id: Int,
    val productName: String,
    val productDescription: Int,
    val price: Int,
    val imageProduct: List<Int>
): Parcelable

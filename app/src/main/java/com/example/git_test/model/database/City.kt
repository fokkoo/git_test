package com.example.git_test.model.database

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class City(
    val name_exersice: String,
    val lat: Double,
    val lon: Double,

    ): Parcelable
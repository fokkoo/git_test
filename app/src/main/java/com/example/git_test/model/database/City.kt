package com.example.git_test.model.database

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class City(
    val name_exersice: String,
    val lat: Double,
    val lon: Double,
    val name_day_train: String,
    val name_workout: String,
    val name_exersice_: String,
    val set_: Double,
    val repetition_: Double,
    val weight: Double,
    val weightMax: Double

    ): Parcelable
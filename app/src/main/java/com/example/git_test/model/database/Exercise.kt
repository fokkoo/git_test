package com.example.git_test.model.database

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Exercise (
    val workout_: String,
    val exersice_: String

): Parcelable


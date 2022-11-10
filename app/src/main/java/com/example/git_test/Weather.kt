package com.example.git_test

import android.os.Parcelable
import com.example.git_test.model.database.City
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weather (
    val city: City = getDefaultCity(),
    val temperature: Int = 0,
    val feelsLike: Int = 0
): Parcelable {


}

fun getDefaultCity(): City = City("Moscow",55.75,37.61)

// в интерфейсе менять не будем поэтому не мутбл
fun getWorldCities(): List <Weather> = listOf(
    Weather(City("London",51.5,-0.12),1,1),
    Weather(City("Tokio",35.5,139.12),2,2),
    Weather(City("Harare",-17.51,31.01),2,2),
)

fun getRussianCities(): List <Weather> = listOf(
    Weather(City("Moscow",55.7,37.12),-5,6),
    Weather(City("Kazan",55.8,49.12),5,5),
    Weather(City("Vostok Antarctic station",-78.28,106.50),5,5),
)
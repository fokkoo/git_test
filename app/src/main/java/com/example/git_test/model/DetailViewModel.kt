package com.example.git_test.model

import androidx.lifecycle.ViewModel
import com.example.git_test.Weather
import com.example.git_test.model.database.HistoryEntity
import com.example.git_test.model.database.LocalRepositoryImpl
import com.example.git_test.view.App
import java.util.*

class DetailViewModel : ViewModel() {

    private val localRepository: LocalRepository = LocalRepositoryImpl(App.getHistoryDao())

    fun programdelite(){

    }

    fun saveWeather(weather: Weather){
        localRepository.saveEntity(
                HistoryEntity(
                        id=0,
                        city = weather.city.name,
                        temperature = weather.temperature,
                        timestamp = Date().time
                )
        )

    }
}
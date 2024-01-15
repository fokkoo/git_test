package com.example.git_test.model.viewmodel

import androidx.lifecycle.ViewModel
import com.example.git_test.Weather
import com.example.git_test.model.LocalRepository
import com.example.git_test.model.database.HistoryEntity
import com.example.git_test.model.database.LocalRepositoryImpl
import com.example.git_test.view.App
import java.util.*

class DetailViewModel : ViewModel() {

    private  val localRepository : LocalRepository = LocalRepositoryImpl(App.getHistoryDao())

    fun saveWeather (weather: Weather){
        localRepository.saveEntity(
                HistoryEntity(
                        id=0,
                        city = weather.city.name_exersice,
                        temperature = weather.temperature,
                        timestamp = Date().time,
                        day_train = weather.city.name_day_train,
                        workout_ = weather.city.name_workout,
                        exersice_ = weather.city.name_exersice_,
                        set_ = weather.city.set_,
                        repetition_ = weather.city.repetition_,
                        weight = weather.city.weight,
                        weightMR = weather.city.weightMax




                )
        )
    }
}
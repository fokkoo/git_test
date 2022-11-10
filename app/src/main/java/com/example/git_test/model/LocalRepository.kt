package com.example.git_test.model

import com.example.git_test.Weather
import com.example.git_test.model.database.HistoryDao
import com.example.git_test.model.database.HistoryEntity

interface LocalRepository  {

    fun getAllHistory(): List<HistoryEntity>
    fun saveEntity(weather: HistoryEntity)
}
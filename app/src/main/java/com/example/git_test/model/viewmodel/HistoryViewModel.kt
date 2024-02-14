package com.example.git_test.model.viewmodel

import androidx.lifecycle.ViewModel
import com.example.git_test.model.database.HidtoryEntityExercise
import com.example.git_test.model.database.HistoryEntity
import com.example.git_test.model.database.LocalRepositoryImpl
import com.example.git_test.view.App

class HistoryViewModel : ViewModel() {


    fun getAllHistory(): List<HistoryEntity> = historyRepository.getAllHistory()

    fun getAllHistoryExercise(): List<HidtoryEntityExercise> = historyRepository.getAllHistoryExercise()

    //  fun deliteAllHistory() = historyRepository2.getAllHistory()

    private val historyRepository = LocalRepositoryImpl(App.getHistoryDao())
    private val historyRepository2 = LocalRepositoryImpl(App.getHistoryDao())
}
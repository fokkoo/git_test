package com.example.git_test.model.viewmodel

import androidx.lifecycle.ViewModel
import com.example.git_test.model.database.HistoryEntity
import com.example.git_test.model.database.LocalRepositoryImpl
import com.example.git_test.view.App

class HistoryViewModel : ViewModel(){

    private val historyRepository = LocalRepositoryImpl(App.getHistoryDao())
    fun getAllHistory() : List<HistoryEntity> = historyRepository.getAllHistory()
}
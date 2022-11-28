package com.example.git_test.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HistoryEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val city : String,
    val temperature : Int,
    val timestamp: Long
        )

// @PrimaryKey - главный столбец БД, и названия айди и других стобцов
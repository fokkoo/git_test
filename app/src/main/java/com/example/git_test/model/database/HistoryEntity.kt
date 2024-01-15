package com.example.git_test.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val city: String,
    val temperature: Int,
    val timestamp: Long,
    val day_train: String,
    val workout_: String,
    val exersice_: String,
    val set_: Double,
    val repetition_: Double,
    val weight: Double,
    val weightMR: Double,
        )

// @PrimaryKey - главный столбец БД, и названия айди и других стобцов
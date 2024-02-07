package com.example.git_test.model.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database (entities = [HistoryEntity::class, HidtoryEntityExercise::class], version = 2, exportSchema = true)
abstract class HistoryDataBase: RoomDatabase() {

    abstract fun historyDao(): HistoryDao
}


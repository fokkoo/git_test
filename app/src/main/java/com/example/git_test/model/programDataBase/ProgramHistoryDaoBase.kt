
package com.example.git_test.model.programDataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.git_test.model.programDataBase.ProgramHistoryEntity

@Database (entities = [ProgramHistoryEntity::class], version = 1, exportSchema = true)
abstract class HistoryDataBase: RoomDatabase() {

    abstract fun programHistoryDao(): ProgramHistoryDao
}

@Database (entities = [ProgramHistoryEntity::class], version = 1, exportSchema = true)
abstract class ProgramHistoryDataBase: RoomDatabase() {

    abstract fun programhistoryDao(): ProgramHistoryDao
}
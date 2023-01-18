package com.example.git_test.model.programDataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.git_test.model.database.HistoryDao


@Database(entities = arrayOf(ProgramHistoryEntity::class),version = 1,exportSchema = true)
abstract class ProgramMyHistoryDataBase : RoomDatabase(){

    abstract fun programhistoryDao(): ProgramHistoryDao
}
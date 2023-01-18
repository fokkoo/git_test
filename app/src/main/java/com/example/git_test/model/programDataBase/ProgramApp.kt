package com.example.git_test.model.programDataBase

import android.app.Application
import androidx.room.Room
import com.example.git_test.model.database.HistoryDao
import com.example.git_test.model.database.HistoryDataBase


class ProgramApp: Application() {

    override fun onCreate() {
        super.onCreate()
        programAppInstance = this
    }

    companion object{
        private var programAppInstance: ProgramApp? = null
        private var programdb: HistoryDataBase? = null
        //
        // name of file where data base is written
        //.allowMainThreadQueries() многопоточность  как заплатка
        private const val PROGRAM_DB_NAME = "ProgramList.db"

        fun getProgramHistoryDao(): HistoryDao {
            if (programdb == null){
                if (programAppInstance==null) throw IllegalStateException("WHF")

                programdb = Room.databaseBuilder(
                    programAppInstance!!,
                    HistoryDataBase::class.java,
                    PROGRAM_DB_NAME
                ).allowMainThreadQueries().build()
            }
            return programdb!!.historyDao()
        }
    }
}
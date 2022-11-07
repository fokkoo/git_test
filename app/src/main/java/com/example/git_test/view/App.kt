package com.example.git_test.view

import android.app.Application
import androidx.room.Room
import com.example.git_test.model.database.HistoryDao
import com.example.git_test.model.database.HistoryDataBase

class App: Application() {
    //add to AndroidManifest android:name=".view.App"

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object{
        private var appInstance: App? = null
        private var db: HistoryDataBase? = null

        // name of file where data base is written

        //.allowMainThreadQueries() многопоточность  как заплатка
        private const val DB_NAME = "History.db"

        fun getHistoryDao(): HistoryDao {
            if (db == null){
                if (appInstance==null) throw IllegalStateException("WHF")

                db = Room.databaseBuilder(
                    appInstance!!,
                    HistoryDataBase::class.java,
                    DB_NAME
                ).allowMainThreadQueries().build()
            }
            return db!!.historyDao()
        }
    }
}
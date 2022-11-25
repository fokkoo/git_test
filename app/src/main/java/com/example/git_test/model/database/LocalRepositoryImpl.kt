package com.example.git_test.model.database

import com.example.git_test.Weather
import com.example.git_test.model.LocalRepository

class LocalRepositoryImpl(private val dao: HistoryDao): LocalRepository {

    override fun getAllHistory(): List<HistoryEntity> = dao.all()


  //  override fun deleteAllHistory(): List<HistoryEntity> = dao.delete()



    override fun saveEntity(weather: HistoryEntity) {
        dao.insert(weather)
    }


}
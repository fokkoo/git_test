package com.example.git_test.model.database

import androidx.room.*


@Dao
interface HistoryDao {

    //запросы в ДАО пульте управленя
    // запрос mySQLlite  SELECT all FROM HistoryEntity
    @Query("SELECT * FROM HistoryEntity")
    fun all(): List<HistoryEntity>

    @Query("SELECT * FROM HistoryEntity WHERE city LIKE :city")
    fun getDatabyWord (city: String): List<HistoryEntity>

    //Dao is smart for autoInsert if conflit - ignor insert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert (entity: HistoryEntity)

    @Update
    fun update (entity: HistoryEntity)

    @Delete
    fun delite (entity: HistoryEntity)

}
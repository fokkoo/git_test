
package com.example.git_test.model.programDataBase

import androidx.room.*


@Dao
interface ProgramHistoryDao {

    //запросы в ДАО пульте управленя
    // запрос mySQLlite  SELECT all FROM HistoryEntity
    @Query("SELECT * FROM ProgramHistoryEntity")
    fun all(): List<ProgramHistoryEntity>

    @Query("SELECT * FROM ProgramHistoryEntity WHERE program LIKE :program")
    fun getDatabyWord(program: String): List<ProgramHistoryEntity>

    //Dao is smart for autoInsert if conflit - ignor insert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entity: ProgramHistoryEntity)

    @Update
    fun update(entity: ProgramHistoryEntity)

    @Delete
    fun delete(entity: ProgramHistoryEntity)


}
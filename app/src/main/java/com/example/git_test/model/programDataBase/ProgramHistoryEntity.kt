

package com.example.git_test.model.programDataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProgramHistoryEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val program : String,
    val exercise : Int,
    val timestamp: Long
)

// @PrimaryKey - главный столбец БД, и названия айди и других стобцов
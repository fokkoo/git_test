package com.example.git_test.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity
data class HidtoryEntityExercise(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val workout_: String,
    val exersice_: String

)

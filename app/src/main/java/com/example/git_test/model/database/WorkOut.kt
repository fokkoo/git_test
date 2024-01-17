package com.example.git_test.model.database

import android.os.Parcelable
import com.example.git_test.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WorkOut(

    val exerciseTitle: String = "0",
    val exerciseDescription: String = "0",
    val exercisePicture: Int = 1,
    val exerciseNumberSET: Int = 1,
    val exerciseWeight: Int = 1,
    val exerciseRepetition: Int = 1,
    val exerciselike:  Int = 1


/*
private String titleWorkout;       // заголовок
    private String descriptionWorkout; // описание
    private int pictureWorkout;        // изображение
    private int numberSET;        // номер подхода
    private int weight;        // вес снаряда
    private int repetition;        // количество повторений
    private boolean likeWorkout;       // флажок
 */

): Parcelable {


}



fun getFirstWorkout1Day(): List <WorkOut> = listOf(
    WorkOut("разминка","разогрейтесь по лучше", R.drawable.start_stech,11,11,11,11),
    WorkOut("жим лежа первый","жми лежа",R.drawable.banch1press,12,12,12,12),
    WorkOut("жим лежа второй","жми сидя",R.drawable.banch1press1stand,13,13,13,13),
    WorkOut("жим лежа третий","жми стоя",R.drawable.benchpresssit,14,14,14,14),

)

fun getSecondWorkout1Day(): List <WorkOut> = listOf(
    WorkOut("разминка","разогрейтесь по лучше",R.drawable.start_stech,11,11,11,11),
    WorkOut("присед первый","приседания со штангой",R.drawable.situp,12,12,12,12),
    WorkOut("присед второй","приседания с гантелями",R.drawable.situp_2,13,13,13,13),
    WorkOut("присед третий","приседания в симитте",R.drawable.situp_smith,14,14,14,14),

    )

fun getFirstWorkout2Day(): List <WorkOut> = listOf(
    WorkOut("разминка","разогрейтесь по лучше", R.drawable.start_stech,11,11,11,11),
    WorkOut("жим лежа первый","жми лежа",R.drawable.banch1press,12,12,12,12),
    WorkOut("присед второй","приседания с гантелями",R.drawable.situp_2,13,13,13,13),
    WorkOut("становая третий","тяни",R.drawable.dead_lift,14,14,14,14),

    )

fun getSecondWorkout2Day(): List <WorkOut> = listOf(
    WorkOut("разминка","разогрейтесь по лучше",R.drawable.start_stech,11,11,11,11),
    WorkOut("присед третий","приседания в симитте",R.drawable.situp_smith,12,12,12,12),
    WorkOut("становая третий","тяни",R.drawable.dead_lift_ruman,13,13,13,13),
    WorkOut("присед первый","приседания со штангой",R.drawable.situp,14,14,14,14),

    )
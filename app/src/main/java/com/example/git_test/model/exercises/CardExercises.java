package com.example.git_test.model.exercises;

public class CardExercises {
    private String titleExercises;       // заголовок
    private String descriptionExercises; // описание
    private int pictureExercises;        // изображение
  /*  private int numberSET;        // номер подхода
    private int weight;        // вес снаряда
    private int repetition;        // количество повторений
    private boolean likeWorkout;       // флажок*/

    public CardExercises(String titleExercises, String descriptionExercises, int pictureExercises ) {
        this.titleExercises = titleExercises;
        this.descriptionExercises = descriptionExercises;
        this.pictureExercises = pictureExercises;

    /*    this.numberSET = numberSET;
        this.weight = weight;
        this.repetition = repetition;

        this.likeWorkout = likeWorkout;*/
    }

    public String getTitleExercises() {

        return titleExercises;
    }

    public String getDescriptionExercises() {

        return descriptionExercises;
    }

    public int getPictureExercises() {

        return pictureExercises;
    }
/*
    public int getNumberSET(){
        return numberSET;
    }

    public int getWeight(){
        return weight;
    }

    public int getRepetition(){
        return repetition;
    }

    public boolean isLikeExercises() {

        return likeExercises;
    }*/
}

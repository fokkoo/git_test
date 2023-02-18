package com.example.git_test.model.repetitionWorkout;

public class CardRepetitionWorkout {
    private String titleWorkout;       // заголовок
    private String descriptionWorkout; // описание
    private int pictureWorkout;        // изображение
    private int numberSET;        // номер подхода
    private int weight;        // вес снаряда
    private int repetition;        // количество повторений
    private boolean likeWorkout;       // флажок

    public CardRepetitionWorkout(String title, String description, int picture, int numberSET, int weight, int repetition, boolean like  ) {
        this.titleWorkout = titleWorkout;
        this.descriptionWorkout = descriptionWorkout;
        this.pictureWorkout = pictureWorkout;

        this.numberSET = numberSET;
        this.weight = weight;
        this.repetition = repetition;

        this.likeWorkout = likeWorkout;
    }

    public String getTitleWorkout() {

        return titleWorkout;
    }

    public String getDescriptionWorkout() {

        return descriptionWorkout;
    }

    public int getPictureWorkout() {

        return pictureWorkout;
    }

    public int getNumberSET(){
        return numberSET;
    }

    public int getWeight(){
        return weight;
    }

    public int getRepetition(){
        return repetition;
    }

    public boolean isLikeWorkout() {

        return likeWorkout;
    }
}

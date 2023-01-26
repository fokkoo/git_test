package com.example.git_test.model.workout;

public class CardWorkout {
    private String titleWorkout;       // заголовок
    private String descriptionWorkout; // описание
    private int pictureWorkout;        // изображение
    private boolean likeWorkout;       // флажок

    public CardWorkout(String title, String description, int picture, boolean like) {
        this.titleWorkout = titleWorkout;
        this.descriptionWorkout = descriptionWorkout;
        this.pictureWorkout = pictureWorkout;
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

    public boolean isLikeWorkout() {

        return likeWorkout;
    }
}

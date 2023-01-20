package com.example.git_test.model.dayTrain;

public class CardDayTrain {
    private String titleDayTrain;       // заголовок
    private String descriptionDayTrain; // описание
    private int pictureDayTrain;        // изображение
    private boolean likeDayTrain;       // флажок

    public CardDayTrain(String title, String description, int picture, boolean like) {
        this.titleDayTrain = titleDayTrain;
        this.descriptionDayTrain = descriptionDayTrain;
        this.pictureDayTrain = pictureDayTrain;
        this.likeDayTrain = likeDayTrain;
    }

    public String getTitleDayTrain() {

        return titleDayTrain;
    }

    public String getDescriptionDayTrain() {

        return descriptionDayTrain;
    }

    public int getPictureDayTrain() {
        return pictureDayTrain;
    }

    public boolean isLikeDayTrain() {

        return likeDayTrain;
    }
}

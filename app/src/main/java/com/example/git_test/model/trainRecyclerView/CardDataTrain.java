package com.example.git_test.model.trainRecyclerView;

public class CardDataTrain {
    private String title;       // заголовок
    private String description; // описание
    private int picture;        // изображение
    private boolean like;       // флажок

    public CardDataTrain(String title, String description, int picture, boolean like) {
        this.title = title;
        this.description = description;
        this.picture = picture;
        this.like = like;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPicture() {
        return picture;
    }

    public boolean isLike() {
        return like;
    }
}


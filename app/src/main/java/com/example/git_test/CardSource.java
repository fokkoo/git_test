package com.example.git_test;

public interface CardSource {

    // отдавать позицию карточки для адаптера
    CardData getCardData(int position);

    CardSource init(CardSourceResponse  response);

    void deliteCardData (int position);
    void updateCardData (int position, CardData cardData);
    void addCardData ( CardData cardData);
    void clearCardData ();

    // отдавать количество  карточек в данных
    int size();
}

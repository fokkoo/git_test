package com.example.git_test;

public interface CardSource2 {

    CardData getCardData(int position);

    CardSource2 init(CardSourceResponse  response);

    void deliteCardData (int position);
    void updateCardData (int position, CardData cardData);
    void addCardData ( CardData cardData);
    void clearCardData ();


    int size();
}

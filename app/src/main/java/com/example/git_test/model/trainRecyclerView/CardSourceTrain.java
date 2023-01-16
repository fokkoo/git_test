package com.example.git_test.model.trainRecyclerView;

public interface CardSourceTrain {

    CardDataTrain getCardData(int position);

    CardSourceTrain init(CardSourceResponseTrain  response);

    void deliteCardData (int position);
    void updateCardData (int position, CardDataTrain cardData);
    void addCardData ( CardDataTrain cardData);
    void clearCardData ();


    int size();
}

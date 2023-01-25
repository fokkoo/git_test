package com.example.git_test.model.dayTrain;

import com.example.git_test.model.trainRecyclerView.CardDataTrain;
import com.example.git_test.model.trainRecyclerView.CardSourceResponseTrain;

public interface CardSourceDayTrain {

    CardDataTrain getCardData(int position);

    CardSourceDayTrain init(CardSourceResponseTrain response);

    void deliteCardData(int position);

    void updateCardData(int position, CardDataTrain cardData);

    void addCardData(CardDataTrain cardData);

    void clearCardData();

    int size();
}

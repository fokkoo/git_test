package com.example.git_test.model.workout;

import com.example.git_test.model.trainRecyclerView.CardDataTrain;
import com.example.git_test.model.trainRecyclerView.CardSourceResponseTrain;

public interface CardSourceWorkout {

    CardDataTrain getCardData(int position);

    CardSourceWorkout init(CardSourceResponseTrain response);

    void deliteCardData(int position);

    void updateCardData(int position, CardDataTrain cardData);

    void addCardData(CardDataTrain cardData);

    void clearCardData();

    int size();
}

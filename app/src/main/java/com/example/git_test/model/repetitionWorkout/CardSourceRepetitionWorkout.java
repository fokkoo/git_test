package com.example.git_test.model.repetitionWorkout;

import com.example.git_test.model.trainRecyclerView.CardDataTrain;
import com.example.git_test.model.trainRecyclerView.CardSourceResponseTrain;

public interface CardSourceRepetitionWorkout {

    CardDataTrain getCardData(int position);

    CardSourceRepetitionWorkout init(CardSourceResponseTrain response);

    void deliteCardData(int position);

    void updateCardData(int position, CardDataTrain cardData);

    void addCardData(CardDataTrain cardData);

    void clearCardData();

    int size();
}

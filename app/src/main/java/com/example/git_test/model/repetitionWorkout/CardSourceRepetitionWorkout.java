package com.example.git_test.model.repetitionWorkout;

import com.example.git_test.model.trainRecyclerView.CardDataTrain;
import com.example.git_test.model.trainRecyclerView.CardSourceResponseTrain;

public interface CardSourceRepetitionWorkout {

    CardRepetitionWorkout getCardData(int position);

    CardSourceRepetitionWorkout init(CardSourseResponseRepetitionWorkout response);

    void deliteCardData(int position);

    void updateCardData(int position, CardRepetitionWorkout CardRepetitionWorkout);

    void addCardData(CardRepetitionWorkout CardRepetitionWorkout);

    void clearCardData();

    int size();
}

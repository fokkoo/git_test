package com.example.git_test.model.repetitionWorkout;

public interface CardSourceRepetitionWorkout {

  //  CardDataTrain getCardData(int position);

    CardRepetitionWorkout getCardData(int position);

    CardSourceRepetitionWorkout init(CardSourseResponseRepetitionWorkout response);

    void deliteCardData(int position);

    void updateCardData(int position, CardRepetitionWorkout CardRepetitionWorkout);

    void addCardData(CardRepetitionWorkout CardRepetitionWorkout);

    void clearCardData();

    int size();
}

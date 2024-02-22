package com.example.git_test.model.exercises;

import com.example.git_test.model.repetitionWorkout.CardRepetitionWorkout;

public interface CardSourceExersises {

    CardExercises getCardData(int position);

 //   CardSourceRepetitionWorkout init(CardSourseResponseRepetitionWorkout response);

    void deliteCardData(int position);

    void updateCardData(int position, CardExercises CardExercises);

    void addCardData(CardExercises CardExercises);

    void clearCardData();

    int size();
}

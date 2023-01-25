package com.example.git_test.model.workout;

import android.content.Context;

import com.example.git_test.R;
import com.example.git_test.model.dayTrain.CardSourceDayTrain;
import com.example.git_test.model.trainRecyclerView.CardDataTrain;
import com.example.git_test.model.trainRecyclerView.CardSourceResponseTrain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardSourceImplWorkout implements CardSourceDayTrain {


    private List<CardDataTrain> cards;

    public CardSourceImplWorkout(Context context) {
        //    this.context = context;

        cards = new ArrayList<>(Arrays.asList(
                new CardDataTrain(
                        "Упражнение 1",
                        context.getResources().getString(R.string.description1),
                        R.drawable.program1_base_program,
                        false
                ),
                new CardDataTrain(
                        "Упражнение 2",
                        context.getResources().getString(R.string.description1),
                        R.drawable.program2_circuit_workout,
                        false
                ),
                new CardDataTrain(
                        "Упражнение 3",
                        context.getResources().getString(R.string.description2),
                        R.drawable.program3_fat_burn,
                        false
                ),

                new CardDataTrain(
                        "Упражнение 4",
                        context.getResources().getString(R.string.description2),
                        R.drawable.program4_three_day_split,
                        false
                )
        )
        );
    }

    @Override
    public CardDataTrain getCardData(int position) {
        return cards.get(position);
    }

    @Override
    public CardSourceDayTrain init(CardSourceResponseTrain response) {
        return this;
    }

    @Override
    public void deliteCardData(int position) {
        cards.remove(position);
    }

    @Override
    public void updateCardData(int position, CardDataTrain cardData) {
        cards.set(position, cardData);
    }

    @Override
    public void addCardData(CardDataTrain cardData) {
        cards.add(cardData);
    }

    @Override
    public void clearCardData() {
        cards.clear();
    }

    @Override
    public int size() {
        return cards.size();
    }
}

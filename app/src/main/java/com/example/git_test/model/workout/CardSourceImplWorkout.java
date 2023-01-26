package com.example.git_test.model.workout;

import android.content.Context;

import com.example.git_test.R;
import com.example.git_test.model.dayTrain.CardSourceDayTrain;
import com.example.git_test.model.trainRecyclerView.CardDataTrain;
import com.example.git_test.model.trainRecyclerView.CardSourceResponseTrain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardSourceImplWorkout implements CardSourceWorkout {


    private List<CardDataTrain> cards;

    public CardSourceImplWorkout(Context context) {
        //    this.context = context;

        cards = new ArrayList<>(Arrays.asList(
                new CardDataTrain(
                        context.getResources().getString(R.string.day1),
                        context.getResources().getString(R.string.description1),
                        R.drawable.program1_base_program,
                        false
                ),
                new CardDataTrain(
                        context.getResources().getString(R.string.day2),
                        context.getResources().getString(R.string.description1),
                        R.drawable.program2_circuit_workout,
                        false
                ),
                new CardDataTrain(
                        context.getResources().getString(R.string.day3),
                        context.getResources().getString(R.string.description2),
                        R.drawable.program3_fat_burn,
                        false
                ),

                new CardDataTrain(
                        context.getResources().getString(R.string.day1),
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
    public CardSourceWorkout init(CardSourceResponseTrain response) {
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

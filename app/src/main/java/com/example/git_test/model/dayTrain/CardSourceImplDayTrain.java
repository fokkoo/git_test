package com.example.git_test.model.dayTrain;

import android.content.Context;

import com.example.git_test.R;
import com.example.git_test.model.exercises.CardExercises;
import com.example.git_test.model.trainRecyclerView.CardDataTrain;
import com.example.git_test.model.trainRecyclerView.CardSourceResponseTrain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardSourceImplDayTrain implements CardSourceDayTrain {



    private List<CardDataTrain> cards;

    public CardSourceImplDayTrain(Context context) {
        //    this.context = context;

        cards = new ArrayList<>(Arrays.asList(
                new CardDataTrain(
                        context.getResources().getString(R.string.DTF_base_program),
                        context.getResources().getString(R.string.DTF_base_program_description),
                        R.drawable.day_train_base_program,
                        false
                ),
                new CardDataTrain(
                        context.getResources().getString(R.string.DTF_circuit_workout),
                        context.getResources().getString(R.string.DTF_circuit_description),
                        R.drawable.day_train_circuit_workout,
                        false
                ),
                new CardDataTrain(
                        context.getResources().getString(R.string.DTF_fat_burn_workout),
                        context.getResources().getString(R.string.DTF_fat_burn_description),
                        R.drawable.day_train_fat_burn,
                        false
                ),

                new CardDataTrain(
                        context.getResources().getString(R.string.three_day_split_workout),
                        context.getResources().getString(R.string.description2),
                        R.drawable.day_train_three_day_split,
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

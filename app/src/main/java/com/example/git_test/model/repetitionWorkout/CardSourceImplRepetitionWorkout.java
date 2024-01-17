package com.example.git_test.model.repetitionWorkout;

import android.content.Context;

import com.example.git_test.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardSourceImplRepetitionWorkout implements CardSourceRepetitionWorkout {


    private List<CardRepetitionWorkout> cards;

    public CardSourceImplRepetitionWorkout(Context context) {
        //    this.context = context;

        cards = new ArrayList<>(Arrays.asList(
                new CardRepetitionWorkout(
                        context.getResources().getString(R.string.day1),
                        context.getResources().getString(R.string.description1),
                        R.drawable.program1_base_program,
                        1,
                        50,
                        1,
                        false
                ),
                new CardRepetitionWorkout(
                        context.getResources().getString(R.string.day2),
                        context.getResources().getString(R.string.description1),
                        R.drawable.program1_base_program,
                        2,
                        51,
                        2,
                        false
                ),
                new CardRepetitionWorkout(
                        context.getResources().getString(R.string.day3),
                        context.getResources().getString(R.string.description1),
                        R.drawable.program1_base_program,
                        3,
                        52,
                        3,
                        false
                ),
                new CardRepetitionWorkout(
                        context.getResources().getString(R.string.day1),
                        context.getResources().getString(R.string.description1),
                        R.drawable.program1_base_program,
                        4,
                        54,
                        5,
                        false
                ),
                new CardRepetitionWorkout(
                        context.getResources().getString(R.string.day1),
                        context.getResources().getString(R.string.description1),
                        R.drawable.program1_base_program,
                        5,
                        50,
                        6,
                        false
                ),
                new CardRepetitionWorkout(
                        context.getResources().getString(R.string.day1),
                        context.getResources().getString(R.string.description1),
                        R.drawable.program1_base_program,
                        6,
                        0,
                        0,
                        false
                ),
                new CardRepetitionWorkout(
                        context.getResources().getString(R.string.day1),
                        context.getResources().getString(R.string.description1),
                        R.drawable.program1_base_program,
                        7,
                        0,
                        0,
                        false
                ),
                new CardRepetitionWorkout(
                        context.getResources().getString(R.string.day1),
                        context.getResources().getString(R.string.description1),
                        R.drawable.program1_base_program,
                        8,
                        0,
                        0,
                        false
                ),
                new CardRepetitionWorkout(
                        context.getResources().getString(R.string.day1),
                        context.getResources().getString(R.string.description1),
                        R.drawable.program1_base_program,
                        9,
                        0,
                        0,
                        false
                )

        )
        );
    }





    @Override
    public CardRepetitionWorkout getCardData(int position) {
        return cards.get(position);
    }

    @Override
    public CardSourceRepetitionWorkout init(CardSourseResponseRepetitionWorkout response) {
        return this;
    }



    @Override
    public void deliteCardData(int position) {
        cards.remove(position);
    }

    @Override
    public void updateCardData(int position, CardRepetitionWorkout CardRepetitionWorkout) {
        cards.set(position, CardRepetitionWorkout);
    }

    @Override
    public void addCardData(CardRepetitionWorkout CardRepetitionWorkout) {
        cards.add(CardRepetitionWorkout);
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

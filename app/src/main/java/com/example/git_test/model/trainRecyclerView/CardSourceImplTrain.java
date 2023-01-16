package com.example.git_test.model.trainRecyclerView;

import android.content.Context;

import com.example.git_test.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardSourceImplTrain implements CardSourceTrain {


    // private final Context context;

    private List<CardDataTrain> cards;

    public static final List<String> IMAGES = new ArrayList<>(Arrays.asList(
            "http://placekitten.com/200/300",
            "http://placekitten.com/400/300",
            "http://placekitten.com/400/400"

    )) ;




    public List<CardDataTrain> getCards() {
        return cards;
    }

    public void setCards(List<CardDataTrain> cards) {
        this.cards = cards;
    }


    @Override
    public CardSourceImplTrain init (CardSourceResponseTrain response){

       //1.41.16

        return this;
    }



    public CardSourceImplTrain(Context context) {
        //    this.context = context;

        cards = new ArrayList<>(Arrays.asList(
                new CardDataTrain(
                        context.getResources().getString(R.string.base_program),
                        context.getResources().getString(R.string.description1),
                        R.drawable.program1_base_program,
                        false
                ),
                new CardDataTrain(
                        context.getResources().getString(R.string.circuit_workout),
                        context.getResources().getString(R.string.description1),
                        R.drawable.program2_circuit_workout,
                        false
                ),
                new CardDataTrain(
                        context.getResources().getString(R.string.three_day_split_workout),
                        context.getResources().getString(R.string.description2),
                        R.drawable.program3_fat_burn,
                        false
                ),

                new CardDataTrain(
                        context.getResources().getString(R.string.fat_burn_workout),
                        context.getResources().getString(R.string.description2),
                        R.drawable.program4_three_day_split,
                        false
                ),
                new CardDataTrain(
                        context.getResources().getString(R.string.your_workout),
                        context.getResources().getString(R.string.description1),
                        R.drawable.program5_your_train,
                        false
                ),
        new CardDataTrain(
                context.getResources().getString(R.string.base_program),
                context.getResources().getString(R.string.description1),
                R.drawable.program1_base_program,
                false
        ),
                new CardDataTrain(
                        context.getResources().getString(R.string.circuit_workout),
                        context.getResources().getString(R.string.description1),
                        R.drawable.program2_circuit_workout,
                        false
                ),
                new CardDataTrain(
                        context.getResources().getString(R.string.three_day_split_workout),
                        context.getResources().getString(R.string.description2),
                        R.drawable.program3_fat_burn,
                        false
                ),

                new CardDataTrain(
                        context.getResources().getString(R.string.fat_burn_workout),
                        context.getResources().getString(R.string.description2),
                        R.drawable.program4_three_day_split,
                        false
                ),
                new CardDataTrain(
                        context.getResources().getString(R.string.your_workout),
                        context.getResources().getString(R.string.description1),
                        R.drawable.program5_your_train,
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

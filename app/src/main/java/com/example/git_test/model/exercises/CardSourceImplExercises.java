package com.example.git_test.model.exercises;

import android.content.Context;

import com.example.git_test.R;
import com.example.git_test.model.dayTrain.CardSourceDayTrain;
import com.example.git_test.model.trainRecyclerView.CardDataTrain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardSourceImplExercises implements CardSourceExersises {

    private List<CardExercises> cardsEXERSISES;



    public CardSourceImplExercises(Context context) {


        //    this.context = context;

        cardsEXERSISES = new ArrayList<>(Arrays.asList(
                new CardExercises(
                        "name1111111111111111111111111111111111111111",
                        "descr1111111111111111111111111111111111111",
                        R.drawable.day_train_three_day_split
                ),
                new CardExercises(
                        "name21111111111111111111",
                        "descr111111111111111111111111111111111",
                        R.drawable.day_train_three_day_split
                ),

                new CardExercises(
                        "name21111111111111111111",
                        "descr111111111111111111111111111111111",
                        R.drawable.day_train_three_day_split
                )
        ));
    }
        @Override
        public CardExercises getCardData ( int position){
            return cardsEXERSISES.get(position);
        }

        @Override
        public void deliteCardData ( int position){
            cardsEXERSISES.remove(position);
        }

        @Override
        public void updateCardData ( int position, CardExercises CardExercises){
            cardsEXERSISES.set(position, CardExercises);
        }

        @Override
        public void addCardData (CardExercises CardExercises){
            cardsEXERSISES.add(CardExercises);
        }

        @Override
        public void clearCardData () {
            cardsEXERSISES.clear();
        }

        @Override
        public int size () {
            return cardsEXERSISES.size();
        }

}

package com.example.git_test.model.Delite;

import android.content.Context;

import com.example.git_test.R;
import com.example.git_test.model.trainRecyclerView.CardDataTrain;
import com.example.git_test.model.trainRecyclerView.CardSourceResponseTrain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardSourceImplDelite implements CardSourceDelite {


    // private final Context context;

    private List<CardDataDelite> cards;

    public static final List<String> IMAGES = new ArrayList<>(Arrays.asList(
            "http://placekitten.com/200/300",
            "http://placekitten.com/400/300",
            "http://placekitten.com/400/400"

    )) ;




    public List<CardDataDelite> getCards() {
        return cards;
    }

    public void setCards(List<CardDataDelite> cards) {
        this.cards = cards;
    }


    @Override
    public CardSourceImplDelite init (CardSourceResponseTrain response){

       //1.41.16

        return this;
    }



    public CardSourceImplDelite(Context context, String dayName, String workoutName) {
        //    this.context = context;
      /*  if (DayNumber == 1){

        }*/

     //   String dayName = context.getResources().getString(R.string.base_program);
      //  String workoutName = context.getResources().getString(R.string.day1);

        if (dayName == context.getResources().getString(R.string.DTF_base_program)){

            // Базовая программа

            if (workoutName == context.getResources().getString(R.string.day1)){

                // Базовая программа день 1

                cards = new ArrayList(Arrays.asList(
                        new CardDataDelite(
                                "1-1",
                                context.getResources().getString(R.string.description1),
                                R.drawable.program1_base_program,
                                false
                        ),
                        new CardDataDelite(
                                dayName,
                                workoutName,
                                R.drawable.program1_base_program,
                                false
                        ),
                        new CardDataDelite(
                                context.getResources().getString(R.string.DTF_base_program),
                                context.getResources().getString(R.string.day1),
                                R.drawable.program2_circuit_workout,
                                false
                        )

                )
                );

            } else if (workoutName == context.getResources().getString(R.string.day2)) {

                // Базовая программа день 2
                cards = new ArrayList(Arrays.asList(
                        new CardDataDelite(
                                "1-2",
                                context.getResources().getString(R.string.description1),
                                R.drawable.program_chest,
                                false
                        ),
                        new CardDataDelite(
                                dayName,
                                workoutName,
                                R.drawable.program1_base_program,
                                false
                        ),
                        new CardDataDelite(
                                context.getResources().getString(R.string.DTF_base_program),
                                context.getResources().getString(R.string.day2),
                                R.drawable.program_chest,
                                false
                        ),
                        new CardDataDelite(
                                context.getResources().getString(R.string.your_workout),
                                context.getResources().getString(R.string.description1),
                                R.drawable.program2_circuit_workout,
                                false
                        )

                )
                );

            }

        } else if (dayName == context.getResources().getString(R.string.DTF_circuit_workout)) {
            if (workoutName == context.getResources().getString(R.string.day1)){

                // Базовая программа день 1

                cards = new ArrayList(Arrays.asList(
                        new CardDataDelite(
                                "2-1",
                                context.getResources().getString(R.string.description1),
                                R.drawable.program_legs,
                                false
                        ),
                        new CardDataDelite(
                                dayName,
                                workoutName,
                                R.drawable.program1_base_program,
                                false
                        ),
                        new CardDataDelite(
                                context.getResources().getString(R.string.DTF_circuit_workout),
                                context.getResources().getString(R.string.day1),
                                R.drawable.program_legs,
                                false
                        ),
                        new CardDataDelite(
                                context.getResources().getString(R.string.base_program),
                                context.getResources().getString(R.string.description1),
                                R.drawable.program_legs,
                                false
                        ),
                        new CardDataDelite(
                                context.getResources().getString(R.string.your_workout),
                                context.getResources().getString(R.string.description1),
                                R.drawable.program3_fat_burn,
                                false
                        )

                )
                );

            } else if (workoutName == context.getResources().getString(R.string.day2)) {

                // Базовая программа день 2
                cards = new ArrayList(Arrays.asList(
                        new CardDataDelite(
                                "2-2",
                                context.getResources().getString(R.string.description1),
                                R.drawable.program4_three_day_split,
                                false
                        ),
                        new CardDataDelite(
                                dayName,
                                workoutName,
                                R.drawable.program1_base_program,
                                false
                        ),
                        new CardDataDelite(
                                context.getResources().getString(R.string.DTF_circuit_workout),
                                context.getResources().getString(R.string.day2),
                                R.drawable.program4_three_day_split,
                                false
                        ),
                        new CardDataDelite(
                                context.getResources().getString(R.string.base_program),
                                context.getResources().getString(R.string.description1),
                                R.drawable.program4_three_day_split,
                                false
                        ),
                        new CardDataDelite(
                                context.getResources().getString(R.string.base_program),
                                context.getResources().getString(R.string.description1),
                                R.drawable.program4_three_day_split,
                                false
                        ),
                        new CardDataDelite(
                                context.getResources().getString(R.string.your_workout),
                                context.getResources().getString(R.string.description1),
                                R.drawable.program4_three_day_split,
                                false
                        )

                )
                );

            }

        }else{
            cards = new ArrayList(Arrays.asList(
                    new CardDataDelite(
                            dayName.toString(),
                            context.getResources().getString(R.string.base_program),
                            R.drawable.program1_base_program,
                            false
                    ),
                    new CardDataDelite(
                            workoutName.toString(),
                            context.getResources().getString(R.string.day1),
                            R.drawable.program2_circuit_workout,
                            false
                    )

            )
            );

        }




/*
        if (3>2){
            //////////
            cards = new ArrayList(Arrays.asList(
                    new CardDataDelite(
                            context.getResources().getString(R.string.base_program),
                            context.getResources().getString(R.string.description1),
                            R.drawable.program1_base_program,
                            false
                    ),
                    new CardDataDelite(
                            context.getResources().getString(R.string.your_workout),
                            context.getResources().getString(R.string.description1),
                            R.drawable.program5_your_train,
                            false
                    )

            )
            );
            /////////////
        }
        else{
        cards = new ArrayList(Arrays.asList(
                new CardDataDelite(
                        "Card sourse",
                        context.getResources().getString(R.string.description1),
                        R.drawable.program1_base_program,
                        false
                ),
                new CardDataDelite(
                        context.getResources().getString(R.string.circuit_workout),
                        context.getResources().getString(R.string.description1),
                        R.drawable.program2_circuit_workout,
                        false
                ),
                new CardDataDelite(
                        context.getResources().getString(R.string.three_day_split_workout),
                        context.getResources().getString(R.string.description2),
                        R.drawable.program4_three_day_split,
                        false
                ),

                new CardDataDelite(
                        context.getResources().getString(R.string.fat_burn_workout),
                        context.getResources().getString(R.string.description2),
                        R.drawable.program3_fat_burn,
                        false
                ),
                new CardDataDelite(
                        context.getResources().getString(R.string.your_workout),
                        context.getResources().getString(R.string.description1),
                        R.drawable.program5_your_train,
                        false
                )

        )
        );}*/



    }

    @Override
    public CardDataDelite getCardData(int position) {
        return cards.get(position);
    }

    @Override
    public void deliteCardData(int position) {
        cards.remove(position);
    }

    @Override
    public void updateCardData(int position, CardDataDelite cardData) {
        cards.set(position, cardData);
    }

    @Override
    public void addCardData(CardDataDelite cardData) {
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

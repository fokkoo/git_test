package com.example.git_test.model;


import android.content.Context;

import com.example.git_test.CardData;
import com.example.git_test.CardSource;
import com.example.git_test.CardSourceResponse;
import com.example.git_test.DataProvider;
import com.example.git_test.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardSourceImpl implements CardSource {


    private List<CardData> cards;

  //  private final Context context;

    @Override
    public CardSource init (CardSourceResponse response){
        return  this;
    }

    @Override
    public void deliteCardData(int position) {
        cards.remove(position);
    }

    @Override
    public void updateCardData(int position, CardData cardData) {
        cards.set(position, cardData);
    }

    @Override
    public void addCardData(CardData cardData) {
        cards.add(cardData);
    }

    @Override
    public void clearCardData() {
        cards.clear();
    }


    public CardSourceImpl(Context context) {
      //  this.context = context;


        cards = new ArrayList<>(Arrays.asList(
                new CardData(
                        "CardSours Impl",
                        "CardSours Impl",
                        R.drawable.program_chest,
                        false
                ),
                new CardData(
                        "CardSours Impl",
                        "CardSours Impl",
                        R.drawable.program_chest,
                        false
                ),
                new CardData(
                        "CardSours Impl",
                        "CardSours Impl",
                        R.drawable.program_chest,
                        false
                ),
                new CardData(
                        "CardSours Impl",
                        "CardSours Impl",
                        R.drawable.program_chest,
                        false
                )


        )
        );
    }


    @Override
    public CardData getCardData(int position) {

        //Dataprovider отдает по контексту отдает элемент
        //    return DataProvider.getData(context.getResources())[position];
        return cards.get(position);
    }

    @Override
    public int size() {
        //return DataProvider.getData(context.getResources()).length;
        return cards.size();
    }


}

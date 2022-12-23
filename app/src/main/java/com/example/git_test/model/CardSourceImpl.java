package com.example.git_test.model;


import android.content.Context;

import com.example.git_test.CardData;
import com.example.git_test.CardSource;
import com.example.git_test.DataProvider;

public class CardSourceImpl implements CardSource {

    private final Context context;

public CardSourceImpl (Context context){
    this.context = context;
}


    @Override
    public CardData getCardData(int position) {

    //Dataprovider отдает по контексту отдает элемент
        return DataProvider.getData(context.getResources())[position];
    }

    @Override
    public int size() {
        return DataProvider.getData(context.getResources()).length;
    }
}

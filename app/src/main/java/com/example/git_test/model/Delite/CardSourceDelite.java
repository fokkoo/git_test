package com.example.git_test.model.Delite;

import com.example.git_test.model.trainRecyclerView.CardDataTrain;
import com.example.git_test.model.trainRecyclerView.CardSourceResponseTrain;

public interface CardSourceDelite {

    CardDataDelite getCardData(int position);

    CardSourceDelite init(CardSourceResponseTrain response);

    void deliteCardData (int position);
    void updateCardData (int position, CardDataDelite cardData);
    void addCardData ( CardDataDelite cardData);
    void clearCardData ();


    int size();
}

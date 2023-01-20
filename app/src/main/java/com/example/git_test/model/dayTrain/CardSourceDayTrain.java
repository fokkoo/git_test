package com.example.git_test.model.dayTrain;

import com.example.git_test.model.trainRecyclerView.CardDataTrain;

public interface CardSourceDayTrain {

    CardDataTrain getCardData(int position);

    int size();
}

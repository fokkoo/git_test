package com.example.git_test;

import android.content.res.Resources;

import androidx.annotation.NonNull;

public class DataProvider {

    public static CardData[] getData(@NonNull Resources resources) {

        return new CardData[]{

                new CardData(
                        resources.getString(R.string.program_Legs),
                        resources.getString(R.string.program_Legs_description),
                        R.drawable.program_legs,
                        false
                ),
                new CardData(

                        resources.getString(R.string.program_chest),
                        resources.getString(R.string.program_chest_description),
                        R.drawable.program_chest,
                        false
                ),
                new CardData(
                        resources.getString(R.string.program_Legs),
                        resources.getString(R.string.program_Legs_description),
                        R.drawable.program_legs,
                        false
                ),
                new CardData(

                        resources.getString(R.string.program_chest),
                        resources.getString(R.string.program_chest_description),
                        R.drawable.program_chest,
                        false
                )
        };
    }
}

package com.example.git_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.git_test.model.CardSourceImpl;

public class CardActivityJava extends AppCompatActivity {


    // 49 57
    private itemAdapter2 adapter2;
    private CardSource2 cardSource2;
    private RecyclerView recyclerView2;
    private int currentPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_java);


        recyclerView2 = findViewById(R.id.recyclerViewAC);
        cardSource2 = new CardSourceImpl2(this);
        adapter2 = new itemAdapter2(cardSource2);


        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this)); // либо уакзать в html activity_main app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"



    }
}
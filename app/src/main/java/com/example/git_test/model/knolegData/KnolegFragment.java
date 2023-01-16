package com.example.git_test.model.knolegData;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.git_test.CardSource2;
import com.example.git_test.MainActivity;
import com.example.git_test.R;

import com.example.git_test.itemAdapter2;
import com.example.git_test.model.CardSourceImpl;


public class KnolegFragment extends Fragment {

    private itemAdapter2 adapter;
    private CardSource2 cardSource;
    private RecyclerView recyclerView;
    private int currentPosition = -1;




    public KnolegFragment() {
        // Required empty public constructor
    }


    public static KnolegFragment newInstance(String param1, String param2) {
        KnolegFragment fragment = new KnolegFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_knoleg, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

      /*  recyclerView = recyclerView.findViewById(R.id.knolegRecyclerView);
        cardSource = (CardSource2) new CardSourceImpl(new MainActivity().getApplicationContext());
        adapter = new itemAdapter2(cardSource);
        recyclerView.setAdapter(adapter);*/
    }
}
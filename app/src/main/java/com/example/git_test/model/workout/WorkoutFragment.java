package com.example.git_test.model.workout;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.git_test.MainActivity;
import com.example.git_test.R;
import com.example.git_test.model.dayTrain.CardSourceDayTrain;
import com.example.git_test.model.dayTrain.CardSourceImplDayTrain;
import com.example.git_test.model.dayTrain.DayTrainFragment;
import com.example.git_test.model.dayTrain.itemAdapterDayTrain;
import com.example.git_test.model.repetitionWorkout.RepetitionWorkoutFragment;

public class WorkoutFragment extends Fragment {


    private itemAdapterWorkout adapter;
    private CardSourceWorkout cardSource;
    private RecyclerView recyclerView;
    private int currentPosition = -1;
    public static final String TAG = "ItemAdapter";


    public WorkoutFragment() {
        // Required empty public constructor
    }


    public static WorkoutFragment newInstance(String param1, String param2) {
        WorkoutFragment fragment = new WorkoutFragment();
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


        return inflater.inflate(R.layout.fragment_workout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycleViewWorkout);
        cardSource = new CardSourceImplWorkout(getActivity().getApplicationContext());
        adapter = new itemAdapterWorkout(cardSource);

        recyclerView.setHasFixedSize(true); // так как все элементы списка одинаковы то recyclerView будет с этим работать быстрее
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext())); // либо уакзать в html activity_main app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"



        adapter.setListener(new itemAdapterWorkout.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                currentPosition = position;


                Fragment frag = new RepetitionWorkoutFragment();

                Bundle result = new Bundle();

                result.putString("username","my long texteeeeeeeeeeeeeeeeee");

                frag.setArguments(result);


                Log.d(TAG, "OnItemClickListener" + currentPosition);


/*
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new RepetitionWorkoutFragment());
                fragmentTransaction.commit();

                */
            }
        });




    }




}
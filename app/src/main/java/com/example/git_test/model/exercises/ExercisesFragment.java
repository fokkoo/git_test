package com.example.git_test.model.exercises;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.git_test.R;
import com.example.git_test.model.DetailViewModel;
import com.example.git_test.model.dayTrain.CardSourceDayTrain;
import com.example.git_test.model.dayTrain.CardSourceImplDayTrain;
import com.example.git_test.model.dayTrain.itemAdapterDayTrain;
import com.example.git_test.model.trainRecyclerView.CardDataTrain;
import com.example.git_test.model.trainRecyclerView.CardSourceImplTrain;
import com.example.git_test.model.trainRecyclerView.CardSourceTrain;
import com.example.git_test.model.viewmodel.HistoryViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ExercisesFragment extends Fragment {

    private itemAdapterExercises adapter;
    private CardSourceExersises cardSource;
    private RecyclerView recyclerView;
    private int currentPosition = -1;
    public static final String TAG = "ItemAdapter";

    private DetailViewModel sll;

    private HistoryViewModel HistoryViewModel;

    public synchronized HistoryViewModel getSampleLifecycleListenerHistoryViewModel() {
        if (HistoryViewModel == null) {
            HistoryViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
        }
        return HistoryViewModel;
    }



    public ExercisesFragment() {
        // Required empty public constructor
    }



    public static ExercisesFragment newInstance(String param1, String param2) {
        ExercisesFragment fragment = new ExercisesFragment();
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
        return inflater.inflate(R.layout.fragment_exercises, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.fragment_Recycle_view_exercises);

        List ExersisesList = getSampleLifecycleListenerHistoryViewModel().getAllHistoryExercise();
        List<CardExercises> ExersisesListArray1;

       /*
        ExersisesListArray1 = new ArrayList(Arrays.asList(
                ExersisesList
        ));
*/

        ExersisesListArray1 = new ArrayList(Arrays.asList(
                new CardExercises(
                        "name1",
                        "descr1",
                       1
                )
        ));


        cardSource =new CardSourceImplExercises(getActivity().getApplicationContext());


        /*
        cardSource = new CardSourceExersises() {
            @Override
            public CardExercises getCardData(int position) {
                return ExersisesListArray1.get(position);
            }

            @Override
            public void deliteCardData(int position) {

            }

            @Override
            public void updateCardData(int position, CardExercises CardExercises) {

            }

            @Override
            public void addCardData(CardExercises CardExercises) {

            }

            @Override
            public void clearCardData() {
                ExersisesListArray1.clear();
            }

            @Override
            public int size() {
                return ExersisesList.size();
            }
        };


        */




      //  cardSource = new CardSourceImplDayTrain(getActivity().getApplicationContext());
      //  cardSourceRW = new CardSourceImplTrain(getActivity().getApplicationContext());

        adapter = new itemAdapterExercises(cardSource);

        recyclerView.setHasFixedSize(true); // так как все элементы списка одинаковы то recyclerView будет с этим работать быстрее
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext())); // либо уакзать в html activity_main app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"

    }
}
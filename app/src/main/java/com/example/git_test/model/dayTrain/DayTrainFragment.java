package com.example.git_test.model.dayTrain;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.git_test.MainActivity;
import com.example.git_test.R;
import com.example.git_test.model.AddDataFragmentJava;
import com.example.git_test.model.DetailViewModel;
import com.example.git_test.model.database.Exercise;
import com.example.git_test.model.repetitionWorkout.CardSourceImplRepetitionWorkout;
import com.example.git_test.model.repetitionWorkout.CardSourceRepetitionWorkout;
import com.example.git_test.model.repetitionWorkout.MyRepetitionWorkoutFragment;
import com.example.git_test.model.trainRecyclerView.CardSourceImplTrain;
import com.example.git_test.model.trainRecyclerView.CardSourceTrain;
import com.example.git_test.model.trainRecyclerView.DeliteFragment;
import com.example.git_test.model.trainRecyclerView.TrainFragment;
import com.example.git_test.model.trainRecyclerView.itemAdapterTrain;
import com.example.git_test.model.viewmodel.HistoryViewModel;
import com.example.git_test.model.workout.WorkoutFragment;

import java.util.ArrayList;
import java.util.Arrays;


public class DayTrainFragment extends Fragment {


    private itemAdapterDayTrain adapter;
    private CardSourceDayTrain cardSource;
    private CardSourceTrain cardSourceRW;
   // private CardSourceRepetitionWorkout cardSourceRW;
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


    public synchronized DetailViewModel getSampleLifecycleListener() {
        if (sll == null) {
            sll = new ViewModelProvider(this).get(DetailViewModel.class);
        }
        return sll;
    }


    public DayTrainFragment() {
        // Required empty public constructor
    }


    public static DayTrainFragment newInstance(String param1, String param2) {
        DayTrainFragment fragment = new DayTrainFragment();
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



        return inflater.inflate(R.layout.fragment_day_train, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.Day_train_Recycle_view);
        cardSource = new CardSourceImplDayTrain(getActivity().getApplicationContext());
        cardSourceRW = new CardSourceImplTrain(getActivity().getApplicationContext());

        adapter = new itemAdapterDayTrain(cardSource);

        recyclerView.setHasFixedSize(true); // так как все элементы списка одинаковы то recyclerView будет с этим работать быстрее
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext())); // либо уакзать в html activity_main app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"


        //************WorkOut Data base initialisation

        int sideDataExersice = cardSourceRW.size();


        getSampleLifecycleListenerHistoryViewModel().getAllHistoryExercise().get(0).getExersice_();

        if (getSampleLifecycleListenerHistoryViewModel().getAllHistoryExercise().get(0).getExersice_()==null){
            for (int i = 0; i < sideDataExersice; i++){

                String title = cardSourceRW.getCardData(i).getTitle().toString();
                String description = cardSourceRW.getCardData(i).getDescription().toString();

                getSampleLifecycleListener().saveExercise(new Exercise(title,description));
            }
        }




        //


     //   FragmentTransaction var3 = this.getParentFragmentManager().beginTransaction();

        adapter.setListener(new itemAdapterDayTrain.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                currentPosition = position;


                int[] positionNumber = {position, 0,0};

              // ********************************
                DayTrainFragment fragment = new DayTrainFragment();
                Bundle textBundle = new Bundle();
                textBundle.putInt("text from DTF",currentPosition);
                fragment.setArguments(textBundle);
                getParentFragmentManager().setFragmentResult("text from DTF",textBundle);

                Bundle textTestBundle = new Bundle();
                textTestBundle.putString("test","test");
                fragment.setArguments(textTestBundle);
                getParentFragmentManager().setFragmentResult("test",textTestBundle);
                // ********************************


                // ********************************
                MyRepetitionWorkoutFragment fragmentDTF = new MyRepetitionWorkoutFragment();
                Bundle textBundleDTF = new Bundle();
                textBundleDTF.putInt("text from DTF",currentPosition);
                fragmentDTF.setArguments(textBundleDTF);
                getParentFragmentManager().setFragmentResult("text from DTF",textBundleDTF);

                // ********************************

                // ********************************
                AddDataFragmentJava fragmentADFJ = new AddDataFragmentJava();
                Bundle position_number_day_train = new Bundle();
                position_number_day_train.putInt("text from DTF to AFJ",currentPosition);
                fragmentADFJ.setArguments(position_number_day_train);
                getParentFragmentManager().setFragmentResult("text from DTF to AFJ",position_number_day_train);

                // ********************************

                // ********************************
                DeliteFragment fragmentDF = new DeliteFragment();
                Bundle position_number_day_trainDF = new Bundle();
                position_number_day_trainDF.putInt("text from DTF to AFJ",currentPosition);
                fragmentDF.setArguments(position_number_day_trainDF);
                getParentFragmentManager().setFragmentResult("text from DTF to AFJ",position_number_day_trainDF);

                // ********************************

                // ********************************
                WorkoutFragment fragmentDFA = new WorkoutFragment();
                Bundle position_number_day_trainDFA = new Bundle();
                position_number_day_trainDFA.putIntArray("text from DTF to AFJA",positionNumber);
                fragmentDFA.setArguments(position_number_day_trainDFA);
                getParentFragmentManager().setFragmentResult("text from DTF to AFJA",position_number_day_trainDFA);

                // ********************************

                Log.d(TAG, "OnItemClickListener" + currentPosition);





                //  FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                // fragmentTransaction.replace(R.id.fragment_container, new TrainFragment());
                fragmentTransaction.replace(R.id.fragment_container, new WorkoutFragment());
                fragmentTransaction.commit();
            }
        });




    }
}
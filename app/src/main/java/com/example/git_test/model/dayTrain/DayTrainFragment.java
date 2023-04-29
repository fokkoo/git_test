package com.example.git_test.model.dayTrain;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.git_test.MainActivity;
import com.example.git_test.R;
import com.example.git_test.model.trainRecyclerView.CardSourceImplTrain;
import com.example.git_test.model.trainRecyclerView.CardSourceTrain;
import com.example.git_test.model.trainRecyclerView.DeliteFragment;
import com.example.git_test.model.trainRecyclerView.TrainFragment;
import com.example.git_test.model.trainRecyclerView.itemAdapterTrain;
import com.example.git_test.model.workout.WorkoutFragment;


public class DayTrainFragment extends Fragment {


    private itemAdapterDayTrain adapter;
    private CardSourceDayTrain cardSource;
    private RecyclerView recyclerView;
    private int currentPosition = -1;
    public static final String TAG = "ItemAdapter";


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
        adapter = new itemAdapterDayTrain(cardSource);

        recyclerView.setHasFixedSize(true); // так как все элементы списка одинаковы то recyclerView будет с этим работать быстрее
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext())); // либо уакзать в html activity_main app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"



        adapter.setListener(new itemAdapterDayTrain.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                currentPosition = position;


              // ********************************
                DayTrainFragment fragment = new DayTrainFragment();
                Bundle textBundle = new Bundle();
                textBundle.putString("text from DTF","text from DTF");
                fragment.setArguments(textBundle);
                getParentFragmentManager().setFragmentResult("text from DTF",textBundle);
                // ********************************

                Bundle result = new Bundle();
                result.putInt("df1",currentPosition);
                getParentFragmentManager().setFragmentResult("dataFromFDelite",result);


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
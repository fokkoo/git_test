package com.example.git_test.model.workout;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.git_test.MainActivity;
import com.example.git_test.R;
import com.example.git_test.model.dayTrain.CardSourceDayTrain;
import com.example.git_test.model.dayTrain.CardSourceImplDayTrain;
import com.example.git_test.model.dayTrain.DayTrainFragment;
import com.example.git_test.model.dayTrain.itemAdapterDayTrain;
import com.example.git_test.model.repetitionWorkout.MyRepetitionWorkoutFragment;
import com.example.git_test.model.repetitionWorkout.RepetitionWorkoutFragment;
import com.example.git_test.model.trainRecyclerView.CardSourceImplTrain;

public class WorkoutFragment extends Fragment {




    private String text;

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
        //    text = getArguments().getString("dataFromFDelite");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

     //   View rootView = inflater.inflate(R.layout.activity_main, container, false);
     //   TextView btn = rootView.findViewById(R.id.WorkOutText);
        View v = inflater.inflate(R.layout.fragment_workout, container, false);

        Button button = (Button) v.findViewById(R.id.buttonBack);
        TextView textMod = (TextView) v.findViewById(R.id.WorkOutText);



        //***********************************


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //   fragmentTransaction.replace(R.id.fragment_container, new MyRepetitionWorkoutFragment());
                fragmentTransaction.replace(R.id.fragment_container, new DayTrainFragment());
                fragmentTransaction.commit();
            }
        });
//***********************************

        if (getArguments() != null) {
             text = getArguments().getString("dataFromFDelite");

        }



        //******************************** прием текста из фрагмента
        getParentFragmentManager().setFragmentResultListener("text from DTF", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle textBundle) {

               Integer data = textBundle.getInt("text from DTF");
                TextView textView = (TextView) v.findViewById(R.id.WorkOutText);

           //     textMod.setText(data.toString());

             //   CardSourceImplTrain(getActivity().getSupportFragmentManager())).
            //    textMod.setText( new CardSourceImplTrain(getActivity()).getCardData(data).toString());
                textMod.setText( new CardSourceImplTrain(getActivity()).getCardData(data).getTitle().toString());
              //  new CardSourceImplTrain(getActivity()).getCardData(1).toString();
            }
        });


        //****************************

        return v;
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

                if (getArguments() != null) {
                        text = getArguments().getString("dataFromFDelite");


                }


                Fragment frag = new MyRepetitionWorkoutFragment();

                Bundle result = new Bundle();
                result.putString("df1","my long texteeeeeeeeeeeeeeeeee");

                result.putString("dataFromFWorout","String Value");
                frag.setArguments(result);


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
             //   fragmentTransaction.replace(R.id.fragment_container, new MyRepetitionWorkoutFragment());
                fragmentTransaction.replace(R.id.fragment_container, new RepetitionWorkoutFragment());
                fragmentTransaction.commit();

            }
        });




    }



/*
    private fun writeData() {
        parentFragmentManager.setFragmentResultListener("dataFromFDelite", this,
                { requestKey, result ->
                        val onItemClickPositionDe = result.getInt("df1")

                        binding.trainTitle.text = CardSourceImplTrain(activity).getCardData(
                                onItemClickPositionDe
                        ).title.toString()

                        binding.trainDescription.text = CardSourceImplTrain(activity).getCardData(
                                onItemClickPositionDe
                        ).description.toString()
                        // binding.trainImageView =  CardSourceImplTrain(activity).getCardData(onItemClickPositionDe).picture
                }


        )
    }
    */




}
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

import com.example.git_test.AddDataFragment;
import com.example.git_test.MainActivity;
import com.example.git_test.R;
import com.example.git_test.model.AddDataFragmentJava;
import com.example.git_test.model.dayTrain.CardSourceDayTrain;
import com.example.git_test.model.dayTrain.CardSourceImplDayTrain;
import com.example.git_test.model.dayTrain.DayTrainFragment;
import com.example.git_test.model.dayTrain.itemAdapterDayTrain;
import com.example.git_test.model.repetitionWorkout.MyRepetitionWorkoutFragment;
import com.example.git_test.model.repetitionWorkout.RepetitionWorkoutFragment;
import com.example.git_test.model.trainRecyclerView.CardSourceImplTrain;
import com.example.git_test.model.trainRecyclerView.DeliteFragment;

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

        View v = inflater.inflate(R.layout.fragment_workout, container, false);

        Button button = (Button) v.findViewById(R.id.buttonBack);
        TextView textMod = (TextView) v.findViewById(R.id.WorkOutText);
        TextView textMod2 = (TextView) v.findViewById(R.id.WorkOutText2);


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


        //******************************** прием текста из фрагмента DayTrainFragment
        getParentFragmentManager().setFragmentResultListener("text from DTF", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle textBundle) {

                Integer data = textBundle.getInt("text from DTF");
                TextView textView = (TextView) v.findViewById(R.id.WorkOutText);
                textMod.setText(new CardSourceImplTrain(getActivity()).getCardData(data).getTitle().toString());

                // ******************************** отправка текста
                MyRepetitionWorkoutFragment fragment = new MyRepetitionWorkoutFragment();
                Bundle textBundleNEW = new Bundle();
                textBundleNEW.putInt("text from DTF1", data);
                fragment.setArguments(textBundleNEW);
                getParentFragmentManager().setFragmentResult("text from DTF1", textBundleNEW);

                // ********************************

            }
        });
        //****************************


        //******************************** прием текста из фрагмента2
        getParentFragmentManager().setFragmentResultListener("test", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle textTestBundle) {

                String textTest = textTestBundle.getString("test");
                TextView textView = (TextView) v.findViewById(R.id.WorkOutText);
                textMod2.setText(textTest);

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

                // ********************************
                AddDataFragmentJava fragmentADFJ = new AddDataFragmentJava();
                Bundle position_number_workout = new Bundle();
                position_number_workout.putInt("text from WOF to AFJ",currentPosition);
                fragmentADFJ.setArguments(position_number_workout);
                getParentFragmentManager().setFragmentResult("text from WOF to AFJ",position_number_workout);

                // ********************************


                //****************************
                AddDataFragment fragmentAdd = new AddDataFragment();
                Bundle textBundleAdd = new Bundle();
                textBundleAdd.putString("text from RWF", "text from RWF");

                fragmentAdd.setArguments(textBundleAdd);
                getParentFragmentManager().setFragmentResult("text from RWF", textBundleAdd);


                // ********************************
                MyRepetitionWorkoutFragment fragment = new MyRepetitionWorkoutFragment();
                Bundle textBundle = new Bundle();
                textBundle.putInt("text from RWF", currentPosition);
                fragment.setArguments(textBundle);
                getParentFragmentManager().setFragmentResult("text from RWF", textBundle);

                // ********************************

                Fragment frag = new MyRepetitionWorkoutFragment();
                Bundle result = new Bundle();
                result.putString("df1", "my long texteeeeeeeeeeeeeeeeee");
                result.putString("dataFromFWorout", "String Value");
                frag.setArguments(result);


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //   fragmentTransaction.replace(R.id.fragment_container, new MyRepetitionWorkoutFragment());
               // fragmentTransaction.replace(R.id.fragment_container, new RepetitionWorkoutFragment());
                fragmentTransaction.replace(R.id.fragment_container, new DeliteFragment());
                fragmentTransaction.commit();
            }
        });
    }

}
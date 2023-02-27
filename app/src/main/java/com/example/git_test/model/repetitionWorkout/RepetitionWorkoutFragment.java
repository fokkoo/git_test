package com.example.git_test.model.repetitionWorkout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.git_test.R;
import com.example.git_test.model.workout.CardSourceWorkout;
import com.example.git_test.model.workout.itemAdapterWorkout;


public class RepetitionWorkoutFragment extends Fragment {

   /* private itemAdapterWorkout adapter;
    private CardSourceWorkout cardSource;
    private RecyclerView recyclerView;
    private int currentPosition = -1;
    public static final String TAG = "ItemAdapter";
 */

    private TextView  MainText ;


    private String recivedData;

    public RepetitionWorkoutFragment() {

    }


    public static RepetitionWorkoutFragment newInstance(String param1, String param2) {
        RepetitionWorkoutFragment fragment = new RepetitionWorkoutFragment();
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

     //   MainText.setText(view.findViewById(R.id.RepetitionMainText)) ;

     //   view.findViewById(R.id.RepetitionMainText).



/*
// getting the bundle back from the android
        Bundle bundle = getIntent().getExtras();

// getting the string back
        String title = bundle.getString("key1", "Default");
*/

     //   Bundle bundle = getActivity().getIntent().getExtras();
        //     String data = bundle.getString("keyWorkoutFragmentCurrentPosition");




        Bundle bundle = this.getArguments();


        final String data = "111111111111111111111111111111111111111111111111";

        MainText = (TextView)getActivity().findViewById(R.id.RepetitionMainText);

        String a = bundle.getString("username");

        MainText.setText(a);





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_repetition_workout, container, false);


    }



}
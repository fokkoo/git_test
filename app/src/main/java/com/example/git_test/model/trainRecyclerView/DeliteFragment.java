package com.example.git_test.model.trainRecyclerView;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.git_test.R;
import com.example.git_test.model.Delite.CardSourceDelite;
import com.example.git_test.model.Delite.CardSourceImplDelite;

import com.example.git_test.model.Delite.itemAdapterDelite;
import com.example.git_test.model.dayTrain.CardSourceImplDayTrain;
import com.example.git_test.model.dayTrain.DayTrainFragment;
import com.example.git_test.model.workout.CardSourceImplWorkout;


public class DeliteFragment extends Fragment {


    private itemAdapterDelite adapter;
    private CardSourceDelite cardSource;
    private RecyclerView recyclerView;
    private int currentPosition = -1;
    public static final String TAG = "ItemAdapter";


    public DeliteFragment() {
        // Required empty public constructor
    }


    public static DeliteFragment newInstance(String param1, String param2) {
        DeliteFragment fragment = new DeliteFragment();
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

        View v = inflater.inflate(R.layout.fragment_delite, container, false);

        TextView textViewNameDaytrain = (TextView) v.findViewById(R.id.textDayTrain);
        TextView textViewNameWorkout = (TextView) v.findViewById(R.id.textWorkout);


        //******************************** прием текста из фрагмента DayTrainFragment
        getParentFragmentManager().setFragmentResultListener("text from DTF to AFJ", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle textBundle) {

                Integer number_day_train_position = textBundle.getInt("text from DTF to AFJ");
                String nameWorkout  = new CardSourceImplWorkout(getActivity()).getCardData(number_day_train_position).getTitle().toString();

                textViewNameWorkout.setText(nameWorkout);


            }
        });

        //******************************** прием текста из фрагмента DayTrainFragment
        getParentFragmentManager().setFragmentResultListener("text from WOF to AFJ", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle textBundle) {

                Integer number_workout_train_position = textBundle.getInt("text from WOF to AFJ");
                String nameDayTrain  = new CardSourceImplDayTrain(getActivity()).getCardData(number_workout_train_position).getTitle().toString();

                textViewNameDaytrain.setText(nameDayTrain);

            }
        });

        return v;
    }





    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //******************************** прием текста из фрагмента DayTrainFragment
        getParentFragmentManager().setFragmentResultListener("text from WOF to AFJA", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle textBundle) {

                int[] DayAndWorkoutPosition = textBundle.getIntArray("text from WOF to AFJA");


                String nameDayTrain  = new CardSourceImplDayTrain(getActivity()).getCardData(DayAndWorkoutPosition[0]).getTitle().toString();
                String nameWorkout  = new CardSourceImplWorkout(getActivity()).getCardData(DayAndWorkoutPosition[1]).getTitle().toString();







        recyclerView = view.findViewById(R.id.train_delite_recycleView);
        cardSource = new CardSourceImplDelite(getActivity().getApplicationContext(),nameDayTrain,nameWorkout);
        adapter = new itemAdapterDelite(cardSource);

        recyclerView.setHasFixedSize(true); // так как все элементы списка одинаковы то recyclerView будет с этим работать быстрее
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext())); // либо уакзать в html activity_main app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"

        adapter.setListener(new itemAdapterDelite.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                currentPosition = position;


                Bundle result = new Bundle();
                result.putInt("df1",currentPosition);
                getParentFragmentManager().setFragmentResult("dataFromFDelite",result);



                Log.d(TAG, "OnItemClickListener" + currentPosition);


              //  FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
             //   fragmentTransaction.replace(R.id.fragment_container, new DayTrainFragment());
                fragmentTransaction.replace(R.id.fragment_container, new TrainFragment());
                fragmentTransaction.commit();
            }
        });



            }
        });
    }
}
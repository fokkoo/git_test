package com.example.git_test.model;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

import com.example.git_test.R;
import com.example.git_test.Weather;
import com.example.git_test.model.Delite.CardSourceImplDelite;
import com.example.git_test.model.database.City;
import com.example.git_test.model.dayTrain.CardSourceImplDayTrain;
import com.example.git_test.model.workout.CardSourceImplWorkout;


public class AddDataFragmentJava extends Fragment {

    private Chronometer chronometerCountDown; // инициализация обратного отчета в секундах
    private int counter = 10; // количество секунд отсчитать


    /*
    private  viewModell: DetailViewModel by lazy {
        ViewModelProvider(this).get(DetailViewModel::class.java)
    }
    // kotlin to java
    */
    private DetailViewModel sll;

    public synchronized DetailViewModel getSampleLifecycleListener() {
        if (sll == null) {
            sll = new ViewModelProvider(this).get(DetailViewModel.class);
           // sll = new ViewModelProvider(this).get(DetailViewModel::class.java);
        }
        return sll;
    }





    public AddDataFragmentJava() {
        // Required empty public constructor
    }


    public static AddDataFragmentJava newInstance(String param1, String param2) {
        AddDataFragmentJava fragment = new AddDataFragmentJava();
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

        View v = inflater.inflate(R.layout.fragment_add_data_java, container, false);

        Button button = (Button) v.findViewById(R.id.buttonSaveData);
        Button buttonSaveAndTime = (Button) v.findViewById(R.id.buttonSave);


        TextView text1 = (EditText) v.findViewById(R.id.editTextNumber2);
        TextView text2 = (EditText) v.findViewById(R.id.editSetNumber);
        TextView textEditTime = (EditText) v.findViewById(R.id.editTime);

     //   int Number = 120;
     //   textEditTime.setText(Number);

        TextView text3 = (TextView) v.findViewById(R.id.textViewMaximum);

        TextView textTest = (TextView) v.findViewById(R.id.textView13);

        TextView textViewDayTrainADJ = (TextView) v.findViewById(R.id.textViewDayTrainADJ);
        TextView textViewWorkoutADJ = (TextView) v.findViewById(R.id.textViewWorkoutADJ);
        TextView textViewExerciseADJ = (TextView) v.findViewById(R.id.textViewExerciseADJ);

        TextView textViewWorkOut = (TextView) v.findViewById(R.id.textView18);






        this.chronometerCountDown = (Chronometer) v.findViewById(R.id.chronometerCountDown);
        this.chronometerCountDown.setText(counter + "");



        //******************************** прием текста из фрагмента DayTrainFragment
        getParentFragmentManager().setFragmentResultListener("text from DTF to AFJ", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle textBundle) {

                Integer number_day_train_position = textBundle.getInt("text from DTF to AFJ");
                textViewDayTrainADJ.setText(new CardSourceImplWorkout(getActivity()).getCardData(number_day_train_position).getTitle().toString());
            }
        });

        //******************************** прием текста из фрагмента DayTrainFragment
        getParentFragmentManager().setFragmentResultListener("text from WOF to AFJ", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle textBundle) {

                Integer number_workout_train_position = textBundle.getInt("text from WOF to AFJ");
                textViewWorkOut.setText(new CardSourceImplDayTrain(getActivity()).getCardData(number_workout_train_position).getTitle().toString());
            }
        });



        //******************************** прием массива из фрагмента DayTrainFragment
        getParentFragmentManager().setFragmentResultListener("text from DelF to AFJA", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle textBundle) {

                int[] DayWorkoutAndExersicePosition = textBundle.getIntArray("text from DelF to AFJA");

                textViewDayTrainADJ.setText(new CardSourceImplDayTrain(getActivity()).getCardData(DayWorkoutAndExersicePosition[0]).getTitle().toString());
                textViewWorkoutADJ.setText(new CardSourceImplWorkout(getActivity()).getCardData(DayWorkoutAndExersicePosition[1]).getTitle().toString());
                textViewExerciseADJ.setText(new CardSourceImplDelite(getActivity(),new CardSourceImplDayTrain(getActivity()).getCardData(DayWorkoutAndExersicePosition[0]).getTitle().toString(),new CardSourceImplWorkout(getActivity()).getCardData(DayWorkoutAndExersicePosition[1]).getTitle().toString()).getCardData(DayWorkoutAndExersicePosition[2]).getTitle().toString());
            }
        });



////////////************
        buttonSaveAndTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {



                  counter = new Integer(textEditTime.getText().toString()).intValue();
                int agd     = new Integer(textEditTime.getText().toString()).intValue();
                doStart();
            }
        });

        // This listener will customize the chronometer text content.
        // It will show number from 10 to 0 repeatedly.
        this.chronometerCountDown.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                onChronometerTickHandler();
            }
        });
///////******************





        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                if (text1.getText().toString()==null){
                        String As = "0";
                }
                if (text2.getText().toString()==null){
                    String Bs = "0";
                }

                String weight_number_String = text1.getText().toString();
                int weight_number = new Integer(weight_number_String).intValue();

                int set_number = 1;

                String repetition_number_String = text2.getText().toString();
                int repetition_number = new Integer(repetition_number_String).intValue();

                int C_number;

                C_number = repetition_number*weight_number/30 + weight_number;


                String strI = Integer.toString(C_number);
                text3.setText(strI);

                double weight_number_double;

              //  textTest.setText(textViewWorkOut.getText().toString());

                weight_number_double = (double) weight_number;
                /*

              */
                getSampleLifecycleListener().saveWeather(
                        new Weather(
                                new City("non", 51.5, weight_number_double,textViewWorkOut.getText().toString(),textViewDayTrainADJ.getText().toString(),"w",set_number,repetition_number,weight_number,50.0),
                                repetition_number,
                                1
                        )
                );
          /*      viewModell.saveWeather(
                        new Weather(
                                new City("M", 51.5, weight_number_double),
                                repetition_number,
                                1
                        )
                );

                */

            }


        });

        // Inflate the layout for this fragment
        return v;
    }


    private void onChronometerTickHandler()  {
        if(this.counter < 0) {
            this.counter = 0;
        }
        this.chronometerCountDown.setText(counter + "");
        this.counter--;
    }

    private void doStart() {
        this.chronometerCountDown.start();
    }
}
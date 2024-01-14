package com.example.git_test.model;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.git_test.R;
import com.example.git_test.Weather;
import com.example.git_test.model.database.City;
import com.example.git_test.model.dayTrain.DayTrainFragment;
import kotlin.Lazy;


public class AddDataFragmentJava extends Fragment {

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

        TextView text1 = (EditText) v.findViewById(R.id.editTextNumber2);
        TextView text2 = (EditText) v.findViewById(R.id.editSetNumber);
        TextView text3 = (TextView) v.findViewById(R.id.textViewMaximum);





        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                String As = text1.getText().toString();
                int weight_number = new Integer(As).intValue();

                String Bs = text2.getText().toString();
                int set_number = new Integer(As).intValue();

                int C_number;

                C_number = set_number*weight_number;


                String strI = Integer.toString(C_number);
                text3.setText(strI);

                double weight_number_double;



                weight_number_double = (double) weight_number;
                /*

              */
                getSampleLifecycleListener().saveWeather(
                        new Weather(
                                new City("M", 51.5, weight_number_double),
                                set_number,
                                1
                        )
                );
          /*      viewModell.saveWeather(
                        new Weather(
                                new City("M", 51.5, weight_number_double),
                                set_number,
                                1
                        )
                );

                */

            }
        });

        // Inflate the layout for this fragment
        return v;
    }
}
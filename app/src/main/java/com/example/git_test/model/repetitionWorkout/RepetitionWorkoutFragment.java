package com.example.git_test.model.repetitionWorkout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.git_test.AddDataFragment;
import com.example.git_test.FirstFragment;
import com.example.git_test.FragmentBar;
import com.example.git_test.R;
import com.example.git_test.model.dayTrain.CardSourceImplDayTrain;
import com.example.git_test.model.dayTrain.DayTrainFragment;
import com.example.git_test.model.knolegData.KnolegFragment;
import com.example.git_test.model.trainRecyclerView.CardSourceImplTrain;
import com.example.git_test.model.trainRecyclerView.TrainFragment;
import com.example.git_test.model.workout.CardSourceImplWorkout;
import com.example.git_test.model.workout.CardSourceWorkout;
import com.example.git_test.model.workout.itemAdapterWorkout;


public class RepetitionWorkoutFragment extends Fragment {

    private itemAdapterRepetitionWorkout adapter;
    private CardSourceRepetitionWorkout cardSource;
    private RecyclerView recyclerView;
    private int currentPosition = -1;
    public static final String TAG = "ItemAdapter";


    private TextView MainText;


    private String recivedData;

    public RepetitionWorkoutFragment() {
        // Required empty public constructor
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View v = inflater.inflate(R.layout.fragment_repetition_workout, container, false);

        TextView textMod2 = (TextView) v.findViewById(R.id.RepetitionMainText);

        TextView textBlock = (TextView) v.findViewById(R.id.textView16);
        TextView textDay = (TextView) v.findViewById(R.id.textView19);
        TextView textExercise = (TextView) v.findViewById(R.id.textView21);



       // textMod2.setText("Text rewire");

        Button buttonAddRepTrain = (Button) v.findViewById(R.id.buttonAddRepTrain);

        buttonAddRepTrain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // ********************************
                AddDataFragment fragment = new AddDataFragment();

                int [] abc = new int[0];
                Bundle bundle =new Bundle();
                bundle.putIntArray("some string",abc);

                Bundle textBundleADF = new Bundle();
                textBundleADF.putInt("text from ADF",currentPosition);
                fragment.setArguments(textBundleADF);
                getParentFragmentManager().setFragmentResult("text from RWF",textBundleADF);

                // ********************************

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //   fragmentTransaction.replace(R.id.fragment_container, new MyRepetitionWorkoutFragment());
                fragmentTransaction.replace(R.id.fragment_container, new AddDataFragment());
                fragmentTransaction.commit();
            }
        });

        //******************************** прием текста из фрагмента DayTrainFragment
        getParentFragmentManager().setFragmentResultListener("text from DTF1", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle textBundle) {

                Integer data = textBundle.getInt("text from DTF1");
                TextView textView = (TextView) v.findViewById(R.id.WorkOutText);
                textExercise.setText(data.toString());

            }
        });
        //****************************

        //******************************** прием текста из фрагмента
        getParentFragmentManager().setFragmentResultListener("text from RWF", this, new FragmentResultListener() {

            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle textBundle) {

                Integer data = textBundle.getInt("text from RWF");
                Integer data2 = textBundle.getInt("text from DTF");

                TextView textView = (TextView) v.findViewById(R.id.WorkOutText);

                textMod2.setText(new CardSourceImplWorkout(getActivity()).getCardData(data).getTitle().toString());
              //  textExercise.setText("textExerciseMYYYYYY".toString());
                textDay.setText(data.toString());

            }
        });




        /*

        //******************************** прием текста из фрагмента
        getParentFragmentManager().setFragmentResultListener("text from RWF", this, new FragmentResultListener() {

            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle textBundle) {



                Integer data = textBundle.getInt("text from RWF");
                Integer data2 = textBundle.getInt("text from DTF");

                TextView textView = (TextView) v.findViewById(R.id.WorkOutText);

                textMod2.setText(new CardSourceImplWorkout(getActivity()).getCardData(data).getTitle().toString());

                textBlock.setText(data.toString());
             //  textDay.setText(data2.toString());

            //    textBlock.setText(new CardSourceImplDayTrain(getActivity()).getCardData(data).getTitle().toString());
            //    textDay.setText(new CardSourceImplWorkout(getActivity()).getCardData(data).getTitle().toString());
           //     textExercise.setText(new CardSourceImplRepetitionWorkout(getActivity()).getCardData(data).getTitleWorkout().toString());

          //      textView.setText( new CardSourceImplTrain(getActivity()).getCardData(3).getTitle().toString());

            //    textMod2.setText( new CardSourceImplTrain(getActivity()).getCardData(3).getTitle().toString());
             //   textMod2.setText( new CardSourceImplTrain(getActivity()).getCardData(data).getTitle().toString());
             //   textMod2.setText("teeeeccecece");
            }





        });*/





      //  return inflater.inflate(R.layout.fragment_repetition_workout, container, false);
        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        recyclerView = view.findViewById(R.id.recycleViewRepetitionWorkout);
        cardSource = new CardSourceImplRepetitionWorkout(getActivity().getApplicationContext());
        adapter = new itemAdapterRepetitionWorkout(cardSource);

        recyclerView.setHasFixedSize(true); // так как все элементы списка одинаковы то recyclerView будет с этим работать быстрее
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext())); // либо уакзать в html activity_main app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"


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
        MainText = (TextView) getActivity().findViewById(R.id.RepetitionMainText);

//        String a = bundle.getString("username");
//        MainText.setText(a);
    }
}
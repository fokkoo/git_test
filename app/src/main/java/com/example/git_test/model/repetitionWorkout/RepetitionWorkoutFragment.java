package com.example.git_test.model.repetitionWorkout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.LifecycleOwner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.git_test.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RepetitionWorkoutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RepetitionWorkoutFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private TextView  MainText ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String recivedData;

    public RepetitionWorkoutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RepetitionWorkoutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RepetitionWorkoutFragment newInstance(String param1, String param2) {
        RepetitionWorkoutFragment fragment = new RepetitionWorkoutFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
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


        Bundle bundle = this.getArguments();
   //     String data = bundle.getString("keyWorkoutFragmentCurrentPosition");

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
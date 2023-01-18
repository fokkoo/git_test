package com.example.git_test.model.trainRecyclerView;

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

import com.example.git_test.R;


public class DeliteFragment extends Fragment {


    private itemAdapterTrain adapter;
    private CardSourceTrain cardSource;
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


        return inflater.inflate(R.layout.fragment_delite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.train_delite_recycleView);
        cardSource = new CardSourceImplTrain(getActivity().getApplicationContext());
        adapter = new itemAdapterTrain(cardSource);

        recyclerView.setHasFixedSize(true); // так как все элементы списка одинаковы то recyclerView будет с этим работать быстрее
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext())); // либо уакзать в html activity_main app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"


        adapter.setListener(new itemAdapterTrain.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                currentPosition = position;
                Log.d(TAG, "OnItemClickListener" + currentPosition);


              //  FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new TrainFragment());
                fragmentTransaction.commit();
            }
        });




    }
}
package com.example.git_test.model.trainRecyclerView;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.git_test.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyTrainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyTrainFragment extends Fragment {


    private itemAdapterTrain adapter;
    private CardSourceTrain cardSource;
    private RecyclerView recyclerView;
    private int currentPosition = -1;

    public MyTrainFragment() {
        // Required empty public constructor
    }


    public static MyTrainFragment newInstance(String param1, String param2) {
        MyTrainFragment fragment = new MyTrainFragment();
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
        return inflater.inflate(R.layout.fragment_my_train, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.fragment_Recycle_view_train);
        cardSource = new CardSourceImplTrain(getActivity().getApplicationContext());
        adapter = new itemAdapterTrain(cardSource);

        recyclerView.setHasFixedSize(true); // так как все элементы списка одинаковы то recyclerView будет с этим работать быстрее
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext())); // либо уакзать в html activity_main app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"


    }
}
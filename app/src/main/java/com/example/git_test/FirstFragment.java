package com.example.git_test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class FirstFragment  extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {


        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.ProgramTrainRecycleView);

/*        ItemAdapterProgram adapter = new ItemAdapterProgram(new String[]{
                "1",
                "2"
        });*/
      //  recyclerView.setAdapter(adapter);
     //   recyclerView.setLayoutManager(new LinearLayoutManager(this));

        return  v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);







                view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });
    }



}
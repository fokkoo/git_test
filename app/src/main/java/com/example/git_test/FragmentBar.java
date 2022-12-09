package com.example.git_test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class FragmentBar extends Fragment {


    public FragmentBar() {
        // Required empty public constructor
    }



    public static FragmentBar newInstance(String param1, String param2) {
        FragmentBar fragment = new FragmentBar();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       // ImageView imageView = (ImageView) getView().findViewById(R.id.barChart);
        BarChart barChart = (BarChart) getView().findViewById(R.id.barChart);

        ArrayList<BarEntry> visitors = new ArrayList<>();

        visitors.add(new BarEntry(200,300));
        visitors.add(new BarEntry(300,400));

        BarDataSet barDataSet = new BarDataSet(visitors,"Visitors");
       // barDataSet.setColor(ColorTemplate.MATERIAL_COLORS,1);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Bar Chart Example");
        barChart.animateY(2000);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bar, container, false);
    }
}
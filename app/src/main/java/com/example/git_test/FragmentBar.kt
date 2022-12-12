package com.example.git_test

import android.os.Bundle


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import java.util.*

class FragmentBar : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ImageView imageView = (ImageView) getView().findViewById(R.id.barChart);
        val barChart = getView()?.findViewById<View>(R.id.barChart) as BarChart
        val visitors = ArrayList<BarEntry>()
        visitors.add(BarEntry(200f, 300f))
        visitors.add(BarEntry(300f, 400f))
        val barDataSet = BarDataSet(visitors, "Visitors")
        // barDataSet.setColor(ColorTemplate.MATERIAL_COLORS,1);
        val barData = BarData(barDataSet)
        barChart.setFitBars(true)
        barChart.data = barData
        barChart.description.text = "Bar Chart Example"
        barChart.animateY(2000)
    }





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bar, container, false)
    }

    companion object {
        fun newInstance(param1: String?, param2: String?): FragmentBar {
            val fragment = FragmentBar()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
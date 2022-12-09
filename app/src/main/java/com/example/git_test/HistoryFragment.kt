package com.example.git_test

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.git_test.databinding.FragmentHistoryBinding
import com.example.git_test.model.viewmodel.HistoryAdapter
import com.example.git_test.model.viewmodel.HistoryViewModel
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.fragment_history.*


class HistoryFragment : Fragment() {

    private val viewModel: HistoryViewModel by lazy {
        ViewModelProvider(this).get(HistoryViewModel::class.java)
    }

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!
    private val adapter: HistoryAdapter by lazy { HistoryAdapter() }

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
*/

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_history, container, false)
        _binding = FragmentHistoryBinding.bind(view)


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewHistory.adapter = adapter

        adapter.setData(viewModel.getAllHistory())
        // viewModel.getAllHistory()





        fun renderData() {

            binding.recyclerViewHistory.visibility = View.VISIBLE
            adapter.setData(viewModel.getAllHistory())

        }

        button_export_text.setOnClickListener() {


            textViewMySQL.text = viewModel.getAllHistory().toString()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }


    fun barBiuld(){



        val barChart: BarChart = binding.barChart

        val visitors = ArrayList<BarEntry>()

     //  visitors.add(1, BarEntry(200,200))

        visitors.add(BarEntry(2000,300))
        visitors.add(BarEntry(2100, 400))
        visitors.add(BarEntry(2200, 500))


        // Создаём двумерный массив
        var visitors2 = arrayOf<Array<Int>>()

        // заполняем нулями
        for (i in 0..4) {
            var array = arrayOf<Int>()
            for (j in 0..4) {
                array += 0
            }
            visitors2 += array
        }



        val barDataSet = BarDataSet(visitors, "visitors")
       // barDataSet.setValueTextColors(Color.BLACK)
      //  barDataSet.setColors(ColorTemplate.MATERIAL_COLORS)
        val barData = BarData(barDataSet)
        barChart.setFitBars(true)
        barChart.data = barData
        barChart.description.text = "Bar Chart Description"
        barChart.animateY(2000)


        // Enables Always-on
        // setAmbientEnabled();
    }

    private fun BarEntry(x: Int, y: Int): BarEntry {

        
        TODO("Not yet implemented")
    }

}
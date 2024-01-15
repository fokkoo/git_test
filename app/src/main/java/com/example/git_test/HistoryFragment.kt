package com.example.git_test

import android.R.attr
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.git_test.databinding.FragmentHistoryBinding
import com.example.git_test.model.DetailViewModel
import com.example.git_test.model.database.City
import com.example.git_test.model.viewmodel.HistoryAdapter
import com.example.git_test.model.viewmodel.HistoryViewModel
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.fragment_history.*
import android.R.attr.defaultValue





class HistoryFragment : Fragment() {

    private val viewModell: DetailViewModel by lazy {
        ViewModelProvider(this).get(DetailViewModel::class.java)
    }


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

        if (arguments?.getString("key") != null) {
            val myInt = arguments?.getString("key","156")
            textView24.text = myInt.toString()
        }

/*
        val bundleHF = this.arguments
        if (bundleHF != null) {
            val myInt = bundleHF.getInt("key",156)
            textView24.text = myInt.toString()
        }
*/

        val bundle = arguments
        if (bundle != null) {
            val KEY_MSG_1 = "FRAGMENT1_MSG"
            val msg = bundle.getString(KEY_MSG_1)
            if (msg != null) {
                //  textMsg.setText(msg)
            }
        }
        return view


     //   return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewHistory.adapter = adapter

        adapter.setData(viewModel.getAllHistory())
        // viewModel.getAllHistory()


        barBiuld()



        fun renderData() {

            binding.recyclerViewHistory.visibility = View.VISIBLE
            adapter.setData(viewModel.getAllHistory())

        }

        button_export_text.setOnClickListener() {


            textViewMySQL.text = viewModel.getAllHistory().size.toString()

            textViewFromEditText.text = editTextNumber.text

            val TestNumberWheit = editTextNumber.text.toString().toInt()



            viewModell.saveWeather(weather = Weather(City("M", 51.5, 51.5,"w","w","w",50.6,50.0,50.0,50.0), TestNumberWheit, 1))
       //     viewModel.saveWeather(weather = Weather(City(CityFromEditTextInn, 51.5, 51.5), 2, 1))
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }


    fun barBiuld() {


        val barChart: BarChart = binding.barChart

        val visitors = ArrayList<BarEntry>()


        //  textViewMySQL.text = viewModel.getAllHistory().get(1).temperature.toString()

        val sizaDataMYSQL = viewModel.getAllHistory().size.toInt()

        for (i in 0..sizaDataMYSQL - 1) {
            val Ydata = viewModel.getAllHistory().get(i).temperature.toFloat()
            val Xdata = viewModel.getAllHistory().get(i).id.toFloat()
            visitors.add(BarEntry(Xdata, Ydata))
        }


        val barDataSet = BarDataSet(visitors, "visitors")
        // barDataSet.setValueTextColors(Color.BLACK)
        //  barDataSet.setColors(ColorTemplate.MATERIAL_COLORS)
        val barData = BarData(barDataSet)
        barChart.setFitBars(true)
        barChart.data = barData
        barChart.description.text = "Bar Chart Description"
        barChart.animateY(2000)
    }


}
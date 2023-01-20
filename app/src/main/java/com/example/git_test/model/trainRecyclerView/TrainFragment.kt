package com.example.git_test.model.trainRecyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.git_test.R
import com.example.git_test.Weather
import com.example.git_test.databinding.FragmentTrainBinding
import com.example.git_test.getRussianCities
import com.example.git_test.model.DetailViewModel
import com.example.git_test.model.database.City
import com.example.git_test.model.viewmodel.HistoryViewModel


class TrainFragment : Fragment() {





    private lateinit var adapter: itemAdapterTrain
    private lateinit var recyclerView: RecyclerView

    private var _binding: FragmentTrainBinding? =null
    private val binding get() = _binding!!


    private val secondViewModel: HistoryViewModel by lazy {
        ViewModelProvider(this).get(HistoryViewModel::class.java)
    }


    private val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this).get(DetailViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_train, container, false)
        _binding = FragmentTrainBinding.bind(v)



        return v
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TrainFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.ProgramTrainRecycleView)
 //       recyclerView.layoutManager = layoutManager
 //       recyclerView.setHasFixedSize(true)
 //       recyclerView.adapter = adapter

        var counter = 1

        binding.addProgram.setOnClickListener(){
            counter= counter+1
            binding.trainTitle.text = "yes"+counter.toString()

            binding.trainToastText.text = getRussianCities()[0].city.name.toString()


            val CityFromEditTextInn = binding.trainFragmenteditText.text.toString()
            viewModel.saveWeather(weather = Weather(City(CityFromEditTextInn, 51.5, 51.5), 2, 1))

        }

        binding.readProgram.setOnClickListener(){

            //      adapter.setListener( itemAdapterTrain.OnItemClickListener())
            counter= counter+1
           // binding.trainTitle.text  = getRussianCities()[getRussianCities().size-1].city.name.toString()

            binding.trainTitle.text  = secondViewModel.getAllHistory()[counter].city.toString()

            parentFragmentManager.setFragmentResultListener("dataFromFDelite",this,
                {
                    requestKey, result -> val onItemClickPositionDe = result.getInt("df1")
                    binding.trainTitle.text  =onItemClickPositionDe.toString()
                }




            )

            // Inflate the layout for this fragment

           // currentPosition
        }




    }




}
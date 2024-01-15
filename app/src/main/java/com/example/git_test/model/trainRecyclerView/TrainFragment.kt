package com.example.git_test.model.trainRecyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.git_test.R
import com.example.git_test.Weather
import com.example.git_test.databinding.FragmentTrainBinding
import com.example.git_test.getRussianCities
import com.example.git_test.model.DetailViewModel
import com.example.git_test.model.database.City
import com.example.git_test.model.dayTrain.CardSourceDayTrain
import com.example.git_test.model.dayTrain.DayTrainFragment
import com.example.git_test.model.dayTrain.itemAdapterDayTrain
import com.example.git_test.model.viewmodel.HistoryViewModel


class TrainFragment : Fragment() {





    private lateinit var adapter: itemAdapterDayTrain
    private lateinit var recyclerView: RecyclerView

    private val cardSource: CardSourceDayTrain? = null
    private val currentPosition = -1
    val TAG = "ItemAdapter"

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
   //     recyclerView.layoutManager = layoutManager
 //       recyclerView.setHasFixedSize(true)
     //   recyclerView.adapter = adapter

        var counter = 1

        writeData()


        binding.addProgram.setOnClickListener(){
            counter= counter+1
            binding.trainTitle.text = "yes"+counter.toString()

            binding.trainToastText.text = getRussianCities()[0].city.name_exersice.toString()


            val CityFromEditTextInn = binding.trainFragmenteditText.text.toString()
            viewModel.saveWeather(weather = Weather(City(CityFromEditTextInn, 51.5, 51.5), 2, 1))

        }

        binding.readProgram.setOnClickListener(){

            //      adapter.setListener( itemAdapterTrain.OnItemClickListener())
            counter= counter+1



            // Inflate the layout for this fragment

           // currentPosition
        }

        binding.backProgram.setOnClickListener(){
          //  val Statistics = DeliteFragment()
            val Statistics = DayTrainFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.fragment_container, Statistics)
            transaction.commit()

        }



    }

    private fun writeData() {
        parentFragmentManager.setFragmentResultListener("dataFromFDelite", this,
            { requestKey, result ->
                val onItemClickPositionDe = result.getInt("df1")

                binding.trainTitle.text = CardSourceImplTrain(activity).getCardData(
                    onItemClickPositionDe
                ).title.toString()

                binding.trainDescription.text = CardSourceImplTrain(activity).getCardData(
                    onItemClickPositionDe
                ).description.toString()
                // binding.trainImageView =  CardSourceImplTrain(activity).getCardData(onItemClickPositionDe).picture
            }


        )
    }


}
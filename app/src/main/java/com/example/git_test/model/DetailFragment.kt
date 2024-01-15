package com.example.git_test.model

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.git_test.R
import com.example.git_test.Weather
import com.example.git_test.databinding.DetailFragmentBinding
import com.example.git_test.getRussianCities
import com.example.git_test.model.database.City

class DetailFragment : Fragment() {

    companion object {
        const val WEATHER_EXTRA = " WEATHER_EXTRA"
        fun newInstance(bundle: Bundle): DetailFragment = DetailFragment().apply { arguments = bundle }
    }

    private val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this).get(DetailViewModel::class.java)
    }


    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.detail_fragment, container, false)
        _binding = DetailFragmentBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val CityFromEditText = binding.editTextTextPersonName.text


        binding.buttonDetailFragmentWriteData.setOnClickListener() {
            val weather = arguments?.getParcelable(WEATHER_EXTRA) ?: Weather()

            binding.textDetailFragmentCity.text = getRussianCities()[0].city.name_exersice.toString()

            val toast = Toast.makeText(context, CityFromEditText, Toast.LENGTH_SHORT)


            toast.show()


        }




        binding.buttonRenderData.setOnClickListener() {
            renderData(Weather())
        }


    }

    private fun renderData(state: Weather) {


        val CityFromEditTextIn = binding.editTextTextPersonName.text.toString()
        viewModel.saveWeather(weather = Weather(City(CityFromEditTextIn, 51.5, 51.5,"w","w","w",50.6,50.0,50.0,50.0), 2, 1))

    }


}
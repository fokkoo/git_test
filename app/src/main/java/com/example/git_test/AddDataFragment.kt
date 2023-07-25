package com.example.git_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.git_test.databinding.FragmentAddDataBinding
import com.example.git_test.databinding.FragmentHistoryBinding
import com.example.git_test.model.DetailViewModel
import com.example.git_test.model.database.City
import kotlinx.android.synthetic.main.fragment_add_data.*
import kotlinx.android.synthetic.main.fragment_history.*


class AddDataFragment : Fragment() {

    private val viewModell: DetailViewModel by lazy {
        ViewModelProvider(this).get(DetailViewModel::class.java)
    }

    private var _binding: FragmentAddDataBinding? = null
    private val binding get() = _binding!!





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_data, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSaveData.setOnClickListener() {

            val weight_number = editTextNumber2.text.toString().toDouble()
            val set_number = editSetNumber.text.toString().toInt()

            val a = "Hello"
            val b = "World"
            val x = " X "
            val RMaimum = weight_number*36/(37-set_number)
            val unitedText = "$weight_number $x $set_number"

            textView13.text =  unitedText
            textViewMaximum.text = RMaimum.toString()

            viewModell.saveWeather(weather = Weather(City("M", 51.5, weight_number),set_number , 1))
        }

        button3.setOnClickListener(){


        }

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddDataFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
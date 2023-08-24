package com.example.git_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.git_test.databinding.FragmentAddDataBinding
import com.example.git_test.model.DetailViewModel
import com.example.git_test.model.database.City
import com.example.git_test.model.trainRecyclerView.CardSourceImplTrain
import kotlinx.android.synthetic.main.fragment_add_data.*


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



        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_add_data, container, false)
        return v
        //  return inflater.inflate(R.layout.fragment_repetition_workout, container, false);

      //  return inflater.inflate(R.layout.fragment_add_data, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        buttonSaveData.setOnClickListener() {

            var weight_number = editTextNumber2.text.toString().toDouble()
            val set_number = editSetNumber.text.toString().toInt()

            if (weight_number != null){
            val nuberA = 5
            val a = "Hello"
            val b = "World"
            val x = " X "
            val RMaimum = weight_number*36/(37-set_number)
            val unitedText = "$weight_number $x $set_number"

            textView13.text =  unitedText
            textViewMaximum.text = RMaimum.toString()




            viewModell.saveWeather(weather = Weather(City("M", 51.5, weight_number),set_number , 1))
            }
          //  binding.textViewTypeSportExercice.text = "text is here123"

        }

        buttonSave.setOnClickListener(){

            val args = this.arguments

            val data = args?.get("text from DTF")

            val textFromDTF = args?.get("hi")

         //   textViewTypeSportProgram.setText(CardSourceImplTrain(activity).getCardData(data).title.toString())
            textViewNumberSportProgram.setText(textFromDTF.toString())

            fun onFragmentResult(requestKey: String, textBundle: Bundle) {
                val data = textBundle.getInt("text from DTF")


              //  textViewTypeSportProgram.setText(CardSourceImplTrain(activity).getCardData(data).title.toString())
              //  textViewNumberSportProgram.setText(data.toString())

            }

          //  textViewTypeSportProgram.setText(CardSourceImplTrain(activity).getCardData(3).title.toString())
            //******************************** прием текста из фрагмента
            parentFragmentManager.setFragmentResultListener("text from DTF", this,
                { requestKey, textBundle ->
                    val data = textBundle.getInt("text from DTF")
               //     textViewTypeSportProgram.setText(CardSourceImplTrain(activity).getCardData(3).title.toString())
                })

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
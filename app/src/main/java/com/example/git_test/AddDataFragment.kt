package com.example.git_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentResultListener
import androidx.lifecycle.ViewModelProvider
import com.example.git_test.databinding.FragmentAddDataBinding
import com.example.git_test.model.DetailViewModel
import com.example.git_test.model.database.City
import com.example.git_test.model.dayTrain.CardSourceImplDayTrain
import com.example.git_test.model.repetitionWorkout.RepetitionWorkoutFragment
import com.example.git_test.model.trainRecyclerView.CardSourceImplTrain
import com.example.git_test.model.workout.CardSourceImplWorkout
import com.example.git_test.model.workout.WorkoutFragment
import kotlinx.android.synthetic.main.fragment_add_data.*
import kotlinx.android.synthetic.main.fragment_repetition_workout.*


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

        /*
        val bundle321 = Bundle()
        bundle321.putString("key","key")
        AddDataFragment().arguments = bundle321
        */

        //****************************
        /* val fragmentAdd = AddDataFragment()
         val textBundleAdd = Bundle()
         textBundleAdd.putString("text from RWF", "text from RWF")

         fragmentAdd.arguments = textBundleAdd

         */


        //******************************** прием текста из фрагмента
        //****************************


        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_add_data, container, false)


        //******************************** прием текста из фрагмента DayTrainFragment
/*
parentFragmentManager.setFragmentResultListener("text from RWF", this,
 { requestKey, textBundle ->
     val data = textBundle.getInt("text from RWF")

     textView22.text = data.toString()
 })*/
//****************************


        return v
//  return inflater.inflate(R.layout.fragment_repetition_workout, container, false);

//  return inflater.inflate(R.layout.fragment_add_data, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = this.arguments
        if (bundle != null) {
            val myInt = bundle.getInt("text from RWF", android.R.attr.defaultValue)
            textView22.text = myInt.toString()
        }


//   output = arguments?.getString("Key","messege")
/*
val text = arguments?.getInt("text from RWF")
textView22.text = text.toString()
*/


        buttonSaveData.setOnClickListener() {

            var weight_number = editTextNumber2.text.toString().toDouble()
            val set_number = editSetNumber.text.toString().toInt()

            if (weight_number != null) {
                val nuberA = 5
                val a = "Hello"
                val b = "World"
                val x = " X "
                val RMaimum = weight_number * 36 / (37 - set_number)
                val unitedText = "$weight_number $x $set_number"

                textView13.text = unitedText
                textViewMaximum.text = RMaimum.toString()


                var dataArgum = this.arguments

                //  dataArgum?.get("dataFromFDelite").toString()


                textViewTypeSportProgram.text = dataArgum?.get("test").toString()

                //getArguments().getString("dataFromFDelite");


                viewModell.saveWeather(
                    weather = Weather(
                        City("M", 51.5, weight_number),
                        set_number,
                        1
                    )
                )
            }
//  binding.textViewTypeSportExercice.text = "text is here123"

        }

/*   val bundle123 = Bundle()
bundle123.putString("pass","pass")
val fragment123 = RepetitionWorkoutFragment()
fragment123.arguments = bundle123*/
// childFragmentManager?.beginTransaction()?.(R.id.,fragment123)?.commit


        button2.setOnClickListener(){

            val fragment = HistoryFragment()
            val bundleHF = Bundle()
            bundleHF.putInt("key", 1)
            fragment.arguments = bundleHF

            val manager = fragmentManager

           /* val frag_transaction = manager?.beginTransaction()
            frag_transaction?.replace(R.id.fragment_container,HistoryFragment())
            frag_transaction?.commit()*/

            // ********************************
            val fragmentManager = fragmentManager
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            //   fragmentTransaction.replace(R.id.fragment_container, new MyRepetitionWorkoutFragment());
            //   fragmentTransaction.replace(R.id.fragment_container, new MyRepetitionWorkoutFragment());
            fragmentTransaction.replace(R.id.fragment_container, HistoryFragment())
            fragmentTransaction.commit()
        }

        buttonSave.setOnClickListener() {

            val args = this.arguments
            val data = args?.get("text from RWF")
            textView23.text = data.toString()

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
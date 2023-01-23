package com.example.git_test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.git_test.databinding.FragmentStartMenuBinding
import com.example.git_test.model.knolegData.KnolegFragment
import com.example.git_test.model.trainRecyclerView.DeliteFragment
import com.example.git_test.model.trainRecyclerView.MyTrainFragment
import com.example.git_test.model.trainRecyclerView.TrainFragment


class StartMenuFragment : Fragment() {

    private var _binding: FragmentStartMenuBinding? =null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            buttonsControl()
        }
    }

    private fun buttonsControl() {


    }





    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_start_menu, container, false)
        _binding = FragmentStartMenuBinding.bind(view)


        val bundle = arguments
        if (bundle != null) {
            val KEY_MSG_1 = "FRAGMENT1_MSG"
            val msg = bundle.getString(KEY_MSG_1)
            if (msg != null) {
                //  textMsg.setText(msg)
            }
        }
        return view

   //     return inflater.inflate(R.layout.fragment_start_menu, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonTrain.setOnClickListener(){
            val MyTrainFragment =  DeliteFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.fragment_container, MyTrainFragment)
            transaction.commit()

            binding.textCheck.text = "Тренировки"
        }

        binding.buttonMeal.setOnClickListener(){

            binding.textCheck.text = "Питание"
        }

        binding.buttonData.setOnClickListener(){

            val KnolegFragment = KnolegFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.fragment_container, KnolegFragment)
            transaction.commit()

            binding.textCheck.text = "База данных"
        }

        binding.buttonStatistics.setOnClickListener(){

            val Statistics = MyTrainFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.fragment_container, Statistics)
            transaction.commit()

            binding.textCheck.text = "Статистика"
        }

        binding.buttonSettings.setOnClickListener(){

            binding.textCheck.text = "Настройки"
        }


    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StartMenuFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
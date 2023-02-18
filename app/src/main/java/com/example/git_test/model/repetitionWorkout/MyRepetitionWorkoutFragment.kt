package com.example.git_test.model.repetitionWorkout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.git_test.R
import com.example.git_test.databinding.FragmentMyRepetitionWorkoutBinding
import com.example.git_test.databinding.FragmentTrainBinding
import com.example.git_test.model.trainRecyclerView.CardSourceImplTrain
import com.example.git_test.model.trainRecyclerView.DeliteFragment
import com.example.git_test.model.trainRecyclerView.TrainFragment
import com.example.git_test.model.workout.WorkoutFragment


class MyRepetitionWorkoutFragment : Fragment() {


    private var _binding: FragmentMyRepetitionWorkoutBinding? =null
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

        val v = inflater.inflate(R.layout.fragment_my_repetition_workout, container, false)
        _binding = FragmentMyRepetitionWorkoutBinding.bind(v)

        // Inflate the layout for this fragment
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



       binding.buttonGoBack.setOnClickListener(){

           readData()

            val Statistics = TrainFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.fragment_container, Statistics)
            transaction.commit()

        }
    }

    private fun readData() {
        parentFragmentManager.setFragmentResultListener("username", this,
            { requestKey, result ->
                val onItemClickPositionDe = result.getInt("df1")

                binding.MyRepetitionWOHeadText.text = CardSourceImplTrain(activity).getCardData(
                    onItemClickPositionDe
                ).title.toString()

                binding.MyRepetitionWOHeadText.text = CardSourceImplTrain(activity).getCardData(
                    onItemClickPositionDe
                ).description.toString()
                // binding.trainImageView =  CardSourceImplTrain(activity).getCardData(onItemClickPositionDe).picture
            }
        )
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyRepetitionWorkoutFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
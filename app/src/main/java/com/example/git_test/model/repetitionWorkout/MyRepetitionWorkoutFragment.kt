package com.example.git_test.model.repetitionWorkout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.git_test.R
import com.example.git_test.databinding.FragmentMyRepetitionWorkoutBinding
import com.example.git_test.databinding.FragmentTrainBinding
import com.example.git_test.model.DetailViewModel
import com.example.git_test.model.dayTrain.CardSourceDayTrain
import com.example.git_test.model.dayTrain.itemAdapterDayTrain
import com.example.git_test.model.trainRecyclerView.CardSourceImplTrain
import com.example.git_test.model.trainRecyclerView.DeliteFragment
import com.example.git_test.model.trainRecyclerView.TrainFragment
import com.example.git_test.model.workout.CardSourceWorkout
import com.example.git_test.model.workout.WorkoutFragment
import com.example.git_test.model.workout.itemAdapterWorkout


class MyRepetitionWorkoutFragment : Fragment() {

    private lateinit var adapter: itemAdapterRepetitionWorkout
    private lateinit var recyclerView: RecyclerView

    private val cardSource: CardSourceRepetitionWorkout? = null
    private val currentPosition = -1
    val TAG = "ItemAdapter"

   private var _binding: FragmentMyRepetitionWorkoutBinding? =null
    private val binding get() = _binding!!

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
        val v = inflater.inflate(R.layout.fragment_my_repetition_workout, container, false)
        _binding = FragmentMyRepetitionWorkoutBinding.bind(v)

        // Inflate the layout for this fragment
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.MyRepetitionWorkoutRecycleView)

       binding.buttonGoBack.setOnClickListener(){

           readData()

          //  val Statistics = TrainFragment()
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
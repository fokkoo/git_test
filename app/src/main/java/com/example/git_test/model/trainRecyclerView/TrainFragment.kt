package com.example.git_test.model.trainRecyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.git_test.*
import com.example.git_test.databinding.FragmentTrainBinding


class TrainFragment : Fragment() {

    private lateinit var adapter: itemAdapterTrain
    private lateinit var recyclerView: RecyclerView

    private var _binding: FragmentTrainBinding? =null
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
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter


        binding.addProgram.setOnClickListener(){
            binding.trainTitle.text = "yes"
        }



  //      adapter.setListener( itemAdapterTrain.OnItemClickListener())

     

    }




}
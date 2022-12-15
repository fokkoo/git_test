package com.example.git_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.git_test.databinding.FragmentHistoryBinding
import com.example.git_test.databinding.FragmentTrainBinding
import com.example.git_test.model.viewmodel.HistoryAdapter
import com.example.git_test.model.viewmodel.HistoryViewModel


class TrainFragment : Fragment() {

    private var _binding: FragmentTrainBinding? = null
    private val binding get() = _binding!!
    private val adapter: ItemAdapterProgram by lazy { ItemAdapterProgram() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_train, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                TrainFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
    }
}
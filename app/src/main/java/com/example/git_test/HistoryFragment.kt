package com.example.git_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.git_test.databinding.FragmentHistoryBinding
import com.example.git_test.model.viewmodel.HistoryViewModel


class HistoryFragment : Fragment() {

    private val viewModel: HistoryViewModel by lazy {
        ViewModelProvider(this).get(HistoryViewModel::class.java)
    }

    private var _binding : FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
*/

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_history,container,false)
        _binding = FragmentHistoryBinding.bind(view)
                return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
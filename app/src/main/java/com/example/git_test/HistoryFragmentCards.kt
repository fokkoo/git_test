package com.example.git_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.git_test.databinding.FragmentHistoryCardsBinding
import com.example.git_test.model.viewmodel.HistoryAdapter
import kotlinx.android.synthetic.main.fragment_history.*


class HistoryFragmentCards : Fragment() {



    private var _binding: FragmentHistoryCardsBinding? = null
    private val binding get() = _binding!!
  //  private val adapter: itemAdapter by lazy { itemAdapter() }




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
        return inflater.inflate(R.layout.fragment_history_cards, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      //  binding.recyclerViewHistoryCARDS.adapter = adapter

       // adapter.setData(viewModel.getAllHistory())
        // viewModel.getAllHistory()






        fun renderData() {

            binding.recyclerViewHistoryCARDS.visibility = View.VISIBLE
        //    adapter.setData(viewModel.getAllHistory())

        }

     }




    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HistoryFragmentCards().apply {
                arguments = Bundle().apply {

                }
            }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}
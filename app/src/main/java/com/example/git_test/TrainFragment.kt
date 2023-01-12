package com.example.git_test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.git_test.databinding.FragmentTrainBinding
import com.example.git_test.model.CardSourceImpl


class TrainFragment : Fragment() {

    private val adapter: ItemAdapterProgram? = null

    private var _binding: FragmentTrainBinding? = null
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
     //   return inflater.inflate(R.layout.fragment_train, container, false)


        // Inflate the layout for this fragment


        val v = inflater.inflate(R.layout.fragment_train, container, false)
        val recyclerView: RecyclerView = v.findViewById(R.id.ProgramTrainRecycleView)
        val cardSours: CardSource = CardSourceImpl(activity)
        //CardSource cardSours = new CardSourceImpl(cardSours);


    /*    val adapter = ItemAdapterProgram(
            arrayOf(
                "first item",
                "2 item",
                    "3 item",
                    "4 item"
            )
        )*/

       val   recyclerView2 : RecyclerView = v.findViewById(R.id.ProgramTrainRecycleView)
       val cardSource2 = CardSourceImpl2(activity)
       val adapter2 = itemAdapter2(cardSource2)

 //       recyclerView2.setAdapter(adapter2)
        recyclerView2.setLayoutManager(LinearLayoutManager(activity)) // либо уакзать в html activity_main app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"







   //     recyclerView.hasFixedSize() // работает быстрее с одинаковым размером элементов
   //     recyclerView.adapter = adapter
      //  recyclerView.layoutManager = LinearLayoutManager(this)
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
}
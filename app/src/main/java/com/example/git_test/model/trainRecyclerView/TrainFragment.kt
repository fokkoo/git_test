package com.example.git_test.model.trainRecyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.git_test.*
import com.example.git_test.databinding.FragmentStartMenuBinding
import com.example.git_test.databinding.FragmentTrainBinding
import com.example.git_test.model.CardSourceImpl


class TrainFragment : Fragment() {

 //   private val adapter: ItemAdapterProgram? = null

    private lateinit var adapter: itemAdapterTrain
  // private lateinit var adapter: itemAdapter2
    private lateinit var recyclerView: RecyclerView
   // private lateinit var newsArrayList : ArrayList<News>

    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var news : Array<String>



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
      //  dataInitialisation()






        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.ProgramTrainRecycleView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

       // val cardSource2 = CardSourceImpl2(activity)
      //  adapter = itemAdapter2(cardSource2)
      //  adapter = MyAdapter(newsArrayList)
        recyclerView.adapter = adapter


        binding.addProgram.setOnClickListener(){
            binding.trainTitle.text = "yes"
        }

    }



/*
    private fun dataInitialisation(){



        newsArrayList = arrayListOf<News>()

        imageId = arrayOf(

            R.drawable.common_google_signin_btn_icon_light,
            R.drawable.common_google_signin_btn_icon_light_normal,
            R.drawable.common_google_signin_btn_icon_light,
            R.drawable.common_google_signin_btn_icon_light_normal,
            R.drawable.common_google_signin_btn_icon_light_normal
        )

        heading = arrayOf(
            getString(R.string.app_name),
            getString(R.string.app_name),
            getString(R.string.appbar_scrolling_view_behavior),
            getString(R.string.app_name),
            getString(R.string.appbar_scrolling_view_behavior)


        )
        news = arrayOf(
            getString(R.string.app_name),
            getString(R.string.app_name),
            getString(R.string.appbar_scrolling_view_behavior),
            getString(R.string.app_name),
            getString(R.string.appbar_scrolling_view_behavior)

        )
        for (i in imageId.indices) {
            val news = News(imageId[i], heading[i])
            newsArrayList.add(news)

        }
    }
*/
}
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
import com.example.git_test.model.CardSourceImpl


class TrainFragment : Fragment() {

 //   private val adapter: ItemAdapterProgram? = null

    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsArrayList : ArrayList<News>

    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var news : Array<String>


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

        val recyclerView2: RecyclerView = v.findViewById(R.id.ProgramTrainRecycleView)
        val cardSource2 = CardSourceImpl2(activity)
        val adapter2 = itemAdapter2(cardSource2)

        //       recyclerView2.setAdapter(adapter2)
        recyclerView2.layoutManager = LinearLayoutManager(activity) // либо уакзать в html activity_main app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"


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



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialisation()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.ProgramTrainRecycleView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MyAdapter(newsArrayList)
        recyclerView.adapter = adapter
    }

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
}
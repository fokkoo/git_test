package com.example.git_test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment1firstRW : Fragment() {

     private var _binding: Fragment1firstRWBinding? = null// создание объекта байндинг
     private val binding get() = _binding!! // создание объекта байндинг


    var names = arrayOf("hello", "hi", "3,4,4,4,5,6,4")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {


        val view = LayoutInflater.from(context).inflate(R.layout.fragment1_layout, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = ListAdapter(names)
        return view
    }
}

class Fragment1firstRWBinding {

}

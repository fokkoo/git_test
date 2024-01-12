package com.example.git_test.model.workout

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.git_test.model.DetailViewModel

class deliteItClass : Fragment(){

    private val viewModell: DetailViewModel by lazy {
        ViewModelProvider(this).get(DetailViewModel::class.java)
    }


}
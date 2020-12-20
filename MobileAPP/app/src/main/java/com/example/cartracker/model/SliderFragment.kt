package com.example.cartracker.model

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cartracker.R

class SliderFragment : Fragment() {

    var pageTitle : String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.slide1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //fragment_title.text = pageTitle
    }

    fun setTitle(title : String){
        pageTitle = title
    }

}
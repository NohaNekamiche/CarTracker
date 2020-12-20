package com.example.cartracker.ui.addFuel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cartracker.R
import com.example.cartracker.ui.gallery.GalleryViewModel
import com.example.cartracker.ui.home.HomeViewModel

class addFuelFragment : Fragment() {

    private lateinit var homeViewModel: addFuelViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(addFuelViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_add_fuel, container, false)
       // val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
         //   textView.text = it
        })
        return root
    }
}
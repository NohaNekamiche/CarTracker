package com.example.cartracker.ui.Reporter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cartracker.R
import com.example.cartracker.ui.Trajet.TrajetViewModel

class ReporterFragment : Fragment() {

    private lateinit var reporterViewModel: ReporterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        reporterViewModel=
            ViewModelProvider(this).get(ReporterViewModel::class.java)
        val root = inflater.inflate(R.layout.repport, container, false)
        val textView: TextView = root.findViewById(R.id.rep)
        reporterViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}

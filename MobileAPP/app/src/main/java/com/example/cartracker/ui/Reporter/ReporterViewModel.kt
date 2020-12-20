package com.example.cartracker.ui.Reporter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReporterViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is TRajetViewModel Fragment"
    }
    val text: LiveData<String> = _text
}
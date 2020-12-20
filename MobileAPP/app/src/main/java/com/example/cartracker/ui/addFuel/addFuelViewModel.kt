package com.example.cartracker.ui.addFuel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class addFuelViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is addFuel Model Fragment"
    }
    val text: LiveData<String> = _text
}
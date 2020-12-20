package com.example.cartracker.ui.Rappels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RappelsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Rappels Fragment"
    }
    val text: LiveData<String> = _text
}
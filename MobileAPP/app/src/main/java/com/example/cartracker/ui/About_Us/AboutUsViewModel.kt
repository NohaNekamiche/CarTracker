package com.example.cartracker.ui.About_Us

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutUsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is about Model Fragment"
    }
    val text: LiveData<String> = _text
}
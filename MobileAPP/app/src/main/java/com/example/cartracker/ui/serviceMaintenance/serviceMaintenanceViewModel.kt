package com.example.cartracker.ui.serviceMaintenance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class serviceMaintenanceViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Maintenance Fragment"
    }
    val text: LiveData<String> = _text
}
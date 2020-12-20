package com.example.cartracker.APIRessources

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cartracker.APIRessources.Repository.Repository

class DriverViewModelFactory(private val repository: Repository)
    :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DriverViewModel(repository) as T
    }
}
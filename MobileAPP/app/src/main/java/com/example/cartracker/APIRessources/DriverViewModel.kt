package com.example.cartracker.APIRessources

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cartracker.APIRessources.Repository.Repository
import kotlinx.coroutines.launch



class DriverViewModel(private val repository: Repository) :ViewModel(){
    val myResponse : MutableLiveData<PostDriver> = MutableLiveData()
    fun getDriver(){
       viewModelScope.launch {
          val response = repository.getDriver()
           myResponse.value = response
       }
    }

}
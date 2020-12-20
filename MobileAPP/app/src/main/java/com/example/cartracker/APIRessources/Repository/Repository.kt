package com.example.cartracker.APIRessources.Repository

import com.example.cartracker.APIRessources.PostDriver
import com.example.cartracker.APIRessources.api.RetrofitInstance

class Repository {
    suspend fun getDriver():PostDriver{
        return  RetrofitInstance.api.getDriver()
    }
}
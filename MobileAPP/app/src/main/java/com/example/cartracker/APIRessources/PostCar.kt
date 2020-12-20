package com.example.cartracker.APIRessources

data class PostCar (
    val Modèle:String,
    val Matricule:String,
    val TypeCarburant:String,
    val Odomètre:String,
    val Carburant:String,
    val photoCar:String,
    val photoTabBord:String,
    val Status:String,
    val idDriver:Int
)
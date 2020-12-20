package com.example.cartracker.APIRessources

data class PostDriver(
    val Nom : String,
    val Prenom : String ,
    val DateNaiss : String,
    val DatePrendreVoiture: String,
    val DateRemettreVoiture: String,
    val photoDriver: String,
    val photoPermis: String,
    val NumTel:Long,
    val NumSeriePermis:Long,
    val nbBonsConsomme:Int,
    val nbBonsTotal:Int,
    val Email: String,
    val Password: String
)
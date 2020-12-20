package com.example.cartracker.APIRessources

data class PostTrajet (
    val LatDepart: String,
    val LangDepart:String,
    val LatDest: String,
    val LangDest:String,
    val HeureDepart:String,
    val DateDepart:String,
    val HeureDest:String,
    val DateDest:String,
    val Disntance: Float,
    val idDriver: Int
)
  package com.example.cartracker.APIRessources.api

import com.example.cartracker.APIRessources.DefaultReponse
import com.example.cartracker.APIRessources.PostDriver
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface API_Interface {
    @GET("")
    suspend fun getDriver():PostDriver

    @POST("createDriver")
    fun createDriver(
            @Field("Nom") Nom : String,
            @Field("Prenom") Prenom : String,
            @Field("DateNaiss") DateNaiss : String,
            @Field("DatePrendreVoiture") DatePrendreVoiture: String,
            @Field("DateRemettreVoiture") DateRemettreVoiture: String,
            @Field("photoDriver") photoDriver: String,
            @Field("photoPermis") photoPermis: String,
            @Field("NumTel") NumTel:Long,
            @Field("NumSeriePermis") NumSeriePermis:Long,
            @Field("nbBonsConsomme") nbBonsConsomme:Int,
            @Field("nbBonsTotal") nbBonsTotal:Int,
            @Field("Email") Email: String,
            @Field("Password") Password: String
    ):Call<DefaultReponse>


    @POST("/addDriver")
    suspend fun createEmployee(@Body requestBody: RequestBody): Response<ResponseBody>

    @GET("/driver")
    suspend fun getDriverInfo(): Response<ResponseBody>

}
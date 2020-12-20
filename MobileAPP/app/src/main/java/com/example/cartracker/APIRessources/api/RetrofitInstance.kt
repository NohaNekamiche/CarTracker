package com.example.cartracker.APIRessources.api

import android.util.Log
import com.example.cartracker.APIRessources.utils.Constants.Companion.BASE_URL
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val okHttpClient=OkHttpClient.Builder()
            .addInterceptor { chain->
                val original = chain.request()
                val requestBuilder=original.newBuilder()
                        .addHeader("Authorization","")
                        .method(original.method, original.body)
                val request = requestBuilder.build()
                chain.proceed(request)
            }
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: API_Interface by lazy {
        retrofit.create(API_Interface::class.java)
    }
    fun getMethod() {

        // Create Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()

        // Create Service
        val service = retrofit.create(API_Interface::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            /*
             * For @Query: You need to replace the following line with val response = service.getEmployees(2)
             * For @Path: You need to replace the following line with val response = service.getEmployee(53)
             */

            // Do the GET request and get response
            val response = service.getDriverInfo()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    // Convert raw JSON to pretty JSON using GSON library
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = gson.toJson(
                        JsonParser.parseString(
                            response.body()
                                ?.string() // About this thread blocking annotation : https://github.com/square/retrofit/issues/3255
                        )
                    )

                    Log.d("Pretty Printed JSON :", prettyJson)

                } else {

                    Log.e("RETROFIT_ERROR", response.code().toString())

                }
            }
        }
    }
}
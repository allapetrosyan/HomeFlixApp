package com.example.homeflixapplication.network

import com.example.homeflixapplication.models.FData

import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {

    @GET("https://firebasestorage.googleapis.com/v0/b/allatest-app.appspot.com/o/film_data.json?alt=media&token=e4c08087-7748-41b7-8b76-50984ef335fa")
    suspend fun getDataFromApi(): Response<FData>



}
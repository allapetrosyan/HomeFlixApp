package com.example.homeflixapplication.models

import com.google.gson.annotations.SerializedName

data class FData(
    @SerializedName("data")
    val datas:List<FilmGlobalData>
)
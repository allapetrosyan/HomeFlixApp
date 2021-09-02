package com.example.homeflixapplication.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class FilmGlobalData(
    @SerializedName("title")
    val title:String,
    @SerializedName("item")
    val listOfFilmItem:List<FilmItem>,
):Parcelable
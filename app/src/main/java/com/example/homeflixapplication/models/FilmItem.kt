package com.example.homeflixapplication.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
 class FilmItem(
    @SerializedName("item_title")
    val filmNameText:String,
    @SerializedName("small_ic")
    val filmSmallImg: String,
  //  @SerializedName("")
): Parcelable
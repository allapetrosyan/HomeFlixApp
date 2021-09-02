package com.example.homeflixapplication.repo

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.example.homeflixapplication.AppResult
import com.example.homeflixapplication.handleApiError
import com.example.homeflixapplication.handleSuccess
import com.example.homeflixapplication.models.FilmGlobalData

import com.example.homeflixapplication.network.ApiInterface


class RepositoryImpl(
    private val api: ApiInterface,
    private val context: Context
) : Repository {

    override suspend fun getAllImages(): AppResult<List<FilmGlobalData>> {
            return try {
                val response = api.getDataFromApi()
               // val response = api.getDataFromApi()
                if (response.isSuccessful) {
                    response.body()?.let {

                        handleSuccess(it.datas)
                    } ?: run {
                        handleApiError("error")
                    }
                } else {
                    handleApiError("error")
                }
            } catch (e: Exception) {
                Log.d("dwd", "error")
                AppResult.Error(e)
            }


    }




    private fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val activeNetworkInfo = connectivityManager!!.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}
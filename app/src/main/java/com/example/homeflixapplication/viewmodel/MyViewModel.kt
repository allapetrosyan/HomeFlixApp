package com.example.homeflixapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homeflixapplication.AppResult
import com.example.homeflixapplication.models.FilmGlobalData
import com.example.homeflixapplication.repo.Repository
import kotlinx.coroutines.launch

class MyViewModel(private var repository: Repository) : ViewModel() {

    val filmList = MutableLiveData<List<FilmGlobalData>>()
    fun getMutableLiveData() {
        viewModelScope.launch() {
            when (val result = repository.getAllImages()) {
                is AppResult.Success -> {
                    filmList.value = result.successData!!
                }
                is AppResult.Error -> Log.d("dwd", "error")
            }
        }
    }
}
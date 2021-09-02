package com.example.homeflixapplication.repo

import com.example.homeflixapplication.AppResult
import com.example.homeflixapplication.models.FilmGlobalData


interface Repository {
    suspend fun getAllImages() : AppResult<List<FilmGlobalData>>
}
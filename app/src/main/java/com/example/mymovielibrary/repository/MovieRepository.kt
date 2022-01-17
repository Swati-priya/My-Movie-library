package com.example.mymovielibrary.repository

import com.example.mymovielibrary.api.ApiService
import com.example.mymovielibrary.models.Movieitem
import retrofit2.http.Path
import javax.inject.Inject

class MovieRepository
@Inject
constructor(private val  apiService: ApiService){
    suspend fun getMovie()= apiService.getMovie()
  //  suspend fun getMovieDetails(movie_id:Int)= apiService.getMovieDetails(movie_id)
}

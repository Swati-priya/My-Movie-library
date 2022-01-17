package com.example.mymovielibrary.api

import com.example.mymovielibrary.models.Movieitem
import com.example.mymovielibrary.models.Movies
import com.example.mymovielibrary.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

// moviedb:  https://api.themoviedb.org/3/movie/popular?api_key=52034b5afa4cc6c61b2b19a57223af86
//moviedetail: https://api.themoviedb.org/3/movie/512195?api_key=52034b5afa4cc6c61b2b19a57223af86
//poster: https://image.tmdb.org/t/p/w342/lAXONuqg41NwUMuzMiFvicDET9Y.jpg


interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getMovie():Response<Movies>

    @GET("movie/{movie_id}?api_key=52034b5afa4cc6c61b2b19a57223af86")
    suspend fun getMovieDetails(
        @Path("movie_id")
        movie_id: Int
    ): Response<Movieitem>

}
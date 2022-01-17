package com.example.mymovielibrary.models

data class Movies(
    val page: Int,
    val results: List<Movieitem>,
    val total_pages: Int,
    val total_results: Int
)
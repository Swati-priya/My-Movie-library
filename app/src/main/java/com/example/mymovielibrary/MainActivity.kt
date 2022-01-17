package com.example.mymovielibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymovielibrary.adapter.movieAdaptor
import com.example.mymovielibrary.databinding.ActivityMainBinding
import com.example.mymovielibrary.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel:MovieViewModel by viewModels()
    private lateinit var movieadapter: movieAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRv()
    }
    private fun setUpRv(){
        movieadapter = movieAdaptor()
        binding.recyclerView.apply {
            adapter = movieadapter
            layoutManager = LinearLayoutManager(
                this@MainActivity,LinearLayoutManager.VERTICAL,false
            )
            setHasFixedSize(true)
        }
        viewModel.responseMovie.observe(this, {
           movieadapter.movie= it.results
        })



    }
}
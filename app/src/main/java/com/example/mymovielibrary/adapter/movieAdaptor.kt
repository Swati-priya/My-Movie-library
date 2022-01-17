package com.example.mymovielibrary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mymovielibrary.databinding.ActivityMainBinding
import com.example.mymovielibrary.databinding.MovieLayoutAdaptorBinding
import com.example.mymovielibrary.models.Movieitem
import com.example.mymovielibrary.models.Movies

class movieAdaptor:RecyclerView.Adapter<movieAdaptor.MyViewHolder>(){
    inner class MyViewHolder(val binding:MovieLayoutAdaptorBinding):RecyclerView.ViewHolder(binding.root)

    private  val  diffcallback = object : DiffUtil.ItemCallback<Movieitem>(){
        override fun areItemsTheSame(oldItem: Movieitem, newItem: Movieitem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movieitem, newItem: Movieitem): Boolean {
            return oldItem == newItem
        }
    }
    private val differ = AsyncListDiffer(this, diffcallback)
    var movie: List<Movieitem> get() = differ.currentList
    set(value){
        differ.submitList(value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(MovieLayoutAdaptorBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentMovie = movie[position]
        holder.binding.apply { 
            textView.text=currentMovie.original_title
          //  imageView.load(currentMovie.poster_path){
            imageView.load("https://image.tmdb.org/t/p/w342/"+currentMovie.poster_path){
                crossfade(true)
                crossfade(1000)
            }

        }
    }

    override fun getItemCount()  = movie.size

}
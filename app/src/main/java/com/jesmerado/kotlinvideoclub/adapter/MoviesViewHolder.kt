package com.jesmerado.kotlinvideoclub.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jesmerado.kotlinvideoclub.model.Movie
import com.jesmerado.kotlinvideoclub.utils.loadImage
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesViewHolder (view: View): RecyclerView.ViewHolder(view) {
    fun bind(movie: Movie) {
        itemView.movieTitle.text = movie.name
        itemView.movieCover.loadImage(movie.cover)
    }
}
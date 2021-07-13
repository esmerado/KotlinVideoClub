package com.jesmerado.kotlinvideoclub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jesmerado.kotlinvideoclub.R
import com.jesmerado.kotlinvideoclub.model.Movie
import com.jesmerado.kotlinvideoclub.utils.loadImage
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    private var movie: Movie? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        retrieveMovie()
        renderui()
    }

    private fun retrieveMovie(){
        movie = intent.getSerializableExtra("movie") as Movie?
    }

    private fun renderui(){
        detailName.text = movie?.name
        detailDescription.text = movie?.description
        movie?.cover?.let { mCover ->
            detailImage.loadImage(mCover)
        }
    }
}
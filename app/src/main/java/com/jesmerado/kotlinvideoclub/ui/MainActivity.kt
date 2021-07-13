package com.jesmerado.kotlinvideoclub.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import com.google.gson.Gson
import com.jesmerado.kotlinvideoclub.R
import com.jesmerado.kotlinvideoclub.adapter.MoviesAdapter
import com.jesmerado.kotlinvideoclub.model.Movie
import com.jesmerado.kotlinvideoclub.utils.getJsonFromAssets
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MoviesAdapter
    private val copyList = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MoviesAdapter(::onMovieClicked)
        recyclerview.adapter = adapter

        adapter.refreshList(getListFromJson())

        searchField.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    val filteredList: List<Movie> = copyList.filter { it.name.toLowerCase(Locale.getDefault()).contains(newText) }
                    adapter.filterByName(filteredList)
                }
                return false
            }

        })

        btSort.setOnClickListener{
            adapter.orderByName()
        }
    }

    private fun getListFromJson(): ArrayList<Movie> {
        val json: String? = getJsonFromAssets("movies.json")
        val movieList = Gson().fromJson(json, Array<Movie>::class.java).toList()
        copyList.addAll(movieList)
        return ArrayList(movieList)
    }

    private fun onMovieClicked(movie: Movie) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("movie", movie)
        startActivity(intent)
    }
}
package com.jesmerado.kotlinvideoclub.model

import java.io.Serializable

data class Movie (
    val id: Int,
    val name: String,
    val description: String,
    val cover: String,
    val year: Int
    ) : Serializable

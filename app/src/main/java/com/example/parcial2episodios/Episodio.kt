package com.example.parcial2episodios

import java.io.Serializable

data class Episodio(
    val season: Int,
    val episode: Int,
    val name: String,
    val description: String,
    val thumbnailUrl: String,
    val id: Int
) : Serializable

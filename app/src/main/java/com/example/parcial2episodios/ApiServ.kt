package com.example.parcial2episodios

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServ {
    @GET("simpsons/episodes")
    suspend fun getEpisodes(): Response<List<Episodio>>
}


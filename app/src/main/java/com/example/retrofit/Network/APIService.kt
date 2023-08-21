package com.example.retrofit.Network

import com.example.retrofit.Model.MovieModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("marvel")
    fun getMovieList(): Call<MutableList<MovieModel>>
}
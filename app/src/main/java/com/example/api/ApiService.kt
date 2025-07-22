package com.example.api

import com.example.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("posts") // Endpoint de la API
    suspend fun getPosts(): Response<List<Post>>
}
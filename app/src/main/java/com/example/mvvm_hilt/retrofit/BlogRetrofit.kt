package com.example.mvvm_hilt.retrofit

import retrofit2.http.GET

interface BlogRetrofit {
    @GET("users")
    suspend fun get(): List<BlogNetworkEntity>
}
package com.example.jetpackcompose

import com.example.jetpackcompose.model.network.RecipeListNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("search/")
    suspend fun getRecipes(
        @Query("page") page: Int,
        @Query("query") query: String
    ): RecipeListNetworkEntity
}
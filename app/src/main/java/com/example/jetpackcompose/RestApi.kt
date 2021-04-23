package com.example.jetpackcompose

import com.example.jetpackcompose.model.network.RecipeDto
import com.example.jetpackcompose.model.network.RecipeListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("search/")
    suspend fun getRecipes(
        @Query("page") page: Int,
        @Query("query") query: String
    ): RecipeListDto

    @GET("get/")
    suspend fun getRecipe(
        @Query("id") id: Int?
    ): RecipeDto
}
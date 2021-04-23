package com.example.jetpackcompose.repository

import com.example.jetpackcompose.model.domain.Recipe

interface RecipeRepository {
    suspend fun getRecipes(query: String): List<Recipe>
    suspend fun getRecipe(id: Int?): Recipe
}
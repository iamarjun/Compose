package com.example.jetpackcompose.repository

import androidx.paging.PagingData
import com.example.jetpackcompose.model.domain.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    fun getRecipes(query: String): Flow<PagingData<Recipe>>
    suspend fun getRecipe(id: Int?): Recipe
}
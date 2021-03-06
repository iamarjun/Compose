package com.example.jetpackcompose.repository

import com.example.jetpackcompose.RestApi
import com.example.jetpackcompose.model.domain.Recipe
import com.example.jetpackcompose.model.network.RecipeDtoMapper
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val mapper: RecipeDtoMapper,
    private val restApi: RestApi
) : RecipeRepository {

    override suspend fun getRecipes(query: String): List<Recipe> {
        val response = restApi.getRecipes(++pageNo, query)
        return mapper.toDomainList(response.results)
    }

    companion object {
        private var pageNo: Int = 0
    }
}
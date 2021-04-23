package com.example.jetpackcompose.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.jetpackcompose.RestApi
import com.example.jetpackcompose.dataSource.RecipePagingSource
import com.example.jetpackcompose.model.domain.Recipe
import com.example.jetpackcompose.model.network.RecipeDtoMapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val mapper: RecipeDtoMapper,
    private val restApi: RestApi
) : RecipeRepository {

    override fun getRecipes(query: String): Flow<PagingData<Recipe>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                RecipePagingSource(
                    restApi = restApi,
                    query = query,
                    mapper = mapper
                )
            }
        ).flow
    }

    override suspend fun getRecipe(id: Int?): Recipe {
        val response = restApi.getRecipe(id = id)
        return mapper.mapToDomainModel(response)
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 30
    }
}
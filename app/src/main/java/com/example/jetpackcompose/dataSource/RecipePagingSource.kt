package com.example.jetpackcompose.dataSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.jetpackcompose.RestApi
import com.example.jetpackcompose.model.domain.Recipe
import com.example.jetpackcompose.model.network.RecipeDtoMapper
import com.example.jetpackcompose.repository.RecipeRepositoryImpl.Companion.NETWORK_PAGE_SIZE
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RecipePagingSource @Inject constructor(
    private val mapper: RecipeDtoMapper,
    private val restApi: RestApi,
    private val query: String
) : PagingSource<Int, Recipe>() {
    override fun getRefreshKey(state: PagingState<Int, Recipe>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Recipe> {
        val position = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = restApi.getRecipes(
                page = position,
                query = query
            )

            val nextKey = if (response.results.isEmpty())
                null
            else
                position + (params.loadSize / NETWORK_PAGE_SIZE)
            LoadResult.Page(
                data = mapper.toDomainList(response.results),
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }
}
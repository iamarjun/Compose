package com.example.jetpackcompose.di

import com.example.jetpackcompose.RestApi
import com.example.jetpackcompose.model.network.RecipeDtoMapper
import com.example.jetpackcompose.repository.RecipeRepository
import com.example.jetpackcompose.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRecipeRepository(
        mapper: RecipeDtoMapper,
        restApi: RestApi
    ): RecipeRepository = RecipeRepositoryImpl(mapper = mapper, restApi = restApi)
}
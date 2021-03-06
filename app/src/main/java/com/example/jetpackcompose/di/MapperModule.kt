package com.example.jetpackcompose.di

import com.example.jetpackcompose.model.domain.Recipe
import com.example.jetpackcompose.model.mapper.DomainMapper
import com.example.jetpackcompose.model.network.RecipeDto
import com.example.jetpackcompose.model.network.RecipeDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    fun providesRecipeDtoMapper(): DomainMapper<RecipeDto, Recipe> = RecipeDtoMapper()
}
package com.example.jetpackcompose.di

import com.example.jetpackcompose.model.network.RecipeDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    fun providesRecipeDtoMapper(): RecipeDtoMapper = RecipeDtoMapper()
}
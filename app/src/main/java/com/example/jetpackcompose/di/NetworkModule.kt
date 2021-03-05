package com.example.jetpackcompose.di

import com.example.jetpackcompose.BuildConfig
import com.example.jetpackcompose.RestApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideRetrofitBuilder(): Retrofit = Retrofit.Builder()
        .client(OkHttpClient.Builder().build())
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideRestApi(retrofit: Retrofit): RestApi = retrofit.create(RestApi::class.java)
}
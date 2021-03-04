package com.example.jetpackcompose.model.network


import com.google.gson.annotations.SerializedName


data class RecipeListNetworkEntity(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String,
    @SerializedName("results")
    val results: List<RecipeNetWorkEntity>
)
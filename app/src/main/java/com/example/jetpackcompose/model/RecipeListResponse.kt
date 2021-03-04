package com.example.jetpackcompose.model


import com.google.gson.annotations.SerializedName

data class RecipeListResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String,
    @SerializedName("results")
    val results: List<Recipe>
)
package com.example.jetpackcompose.model.network


import com.google.gson.annotations.SerializedName


data class RecipeListDto(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String,
    @SerializedName("results")
    val results: List<RecipeDto>
)
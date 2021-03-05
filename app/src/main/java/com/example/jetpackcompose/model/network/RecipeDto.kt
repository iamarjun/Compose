package com.example.jetpackcompose.model.network


import com.google.gson.annotations.SerializedName

data class RecipeDto(
    @SerializedName("cooking_instructions")
    val cookingInstructions: Any? = null,
    @SerializedName("date_added")
    val dateAdded: String? = "",
    @SerializedName("date_updated")
    val dateUpdated: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("featured_image")
    val featuredImage: String? = "",
    @SerializedName("ingredients")
    val ingredients: List<String>? = listOf(),
    @SerializedName("long_date_added")
    val longDateAdded: Int? = -1,
    @SerializedName("long_date_updated")
    val longDateUpdated: Int? = -1,
    @SerializedName("pk")
    val pk: Int? = -1,
    @SerializedName("publisher")
    val publisher: String? = "",
    @SerializedName("rating")
    val rating: Int? = -1,
    @SerializedName("source_url")
    val sourceUrl: String? = "",
    @SerializedName("title")
    val title: String? = ""
)
package com.example.jetpackcompose.model.network

import com.example.jetpackcompose.model.domain.Recipe
import com.example.jetpackcompose.model.mapper.DomainMapper

class RecipeNetworkMapper : DomainMapper<RecipeDto, Recipe> {
    override fun mapToDomainModel(entity: RecipeDto) = Recipe(
        id = entity.pk,
        title = entity.title,
        publisher = entity.publisher,
        featuredImage = entity.featuredImage,
        rating = entity.rating,
        sourceUrl = entity.sourceUrl,
        ingredients = entity.ingredients,
        dateAdded = entity.dateAdded,
        dateUpdated = entity.dateUpdated
    )

    override fun mapFromDomainModel(domainModel: Recipe) = RecipeDto(
        pk = domainModel.id,
        title = domainModel.title,
        publisher = domainModel.publisher,
        featuredImage = domainModel.featuredImage,
        rating = domainModel.rating,
        sourceUrl = domainModel.sourceUrl,
        ingredients = domainModel.ingredients,
        dateAdded = domainModel.dateAdded,
        dateUpdated = domainModel.dateUpdated
    )

    fun fromEntityList(entities: List<RecipeDto>) =
        entities.map { mapToDomainModel(it) }.toList()

    fun toEntityList(initial: List<Recipe>) = initial.map { mapFromDomainModel(it) }.toList()
}
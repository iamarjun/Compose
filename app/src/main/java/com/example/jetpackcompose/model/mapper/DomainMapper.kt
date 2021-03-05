package com.example.jetpackcompose.model.mapper

interface DomainMapper<T, DomainModel> {

    fun mapToDomainModel(entity: T): DomainModel

    fun mapFromDomainModel(domainModel: DomainModel): T
}
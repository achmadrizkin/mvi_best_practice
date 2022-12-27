package com.example.mvvm_hilt.retrofit

import com.example.mvvm_hilt.model.Blog
import com.example.mvvm_hilt.utils.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor() : EntityMapper<BlogNetworkEntity, Blog> {
    override fun mapFromEntity(entity: BlogNetworkEntity): Blog {
        return Blog(
            id = entity.id,
            username = entity.username,
            email = entity.email,
            website = entity.website
        )
    }

    override fun mapToEntity(domainModel: Blog): BlogNetworkEntity {
        return BlogNetworkEntity(
            id = domainModel.id,
            username = domainModel.username,
            email = domainModel.email,
            website = domainModel.website
        )
    }

    // converting map to object
    fun mapFromEntityList(entity: List<BlogNetworkEntity>): List<Blog> {
        return entity.map { mapFromEntity(it) }
    }
}
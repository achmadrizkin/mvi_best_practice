package com.example.mvvm_hilt.room

import com.example.mvvm_hilt.model.Blog
import com.example.mvvm_hilt.retrofit.BlogNetworkEntity
import com.example.mvvm_hilt.utils.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor() : EntityMapper<BlogCacheEntity, Blog> {
    override fun mapFromEntity(entity: BlogCacheEntity): Blog {
        return Blog(
            id = entity.id,
            username = entity.username,
            email = entity.email,
            website = entity.website
        )
    }

    override fun mapToEntity(domainModel: Blog): BlogCacheEntity {
        return BlogCacheEntity(
            id = domainModel.id,
            username = domainModel.username,
            email = domainModel.email,
            website = domainModel.website
        )
    }

    // converting map to object
    fun mapFromEntityList(entity: List<BlogCacheEntity>): List<Blog> {
        return entity.map { mapFromEntity(it) }
    }}
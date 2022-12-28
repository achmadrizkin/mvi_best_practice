package com.example.mvvm_hilt.repo

import com.example.mvvm_hilt.model.Blog
import com.example.mvvm_hilt.retrofit.BlogRetrofit
import com.example.mvvm_hilt.retrofit.NetworkMapper
import com.example.mvvm_hilt.room.BlogDao
import com.example.mvvm_hilt.room.CacheMapper
import com.example.mvvm_hilt.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepo
@Inject
constructor(
    private val blogRetrofit: BlogRetrofit,
    private val blogDao: BlogDao,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {

    suspend fun getBlog(): Flow<DataState<List<Blog>>> = flow{
        emit(DataState.Loading)
        try {
            val networkBlog = blogRetrofit.get()

            emit(DataState.Success(networkMapper.mapFromEntityList(networkBlog)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }

    suspend fun getBlogFromDao(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        try {
            val cachedBlogs = blogDao.getDao();
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogs)))
            emit(DataState.Offline(cacheMapper.mapFromEntityList(cachedBlogs)))
        } catch(e: Exception) {
            emit(DataState.Error(e))
        }
    }

}
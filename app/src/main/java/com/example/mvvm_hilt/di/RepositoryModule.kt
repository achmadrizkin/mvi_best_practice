package com.example.mvvm_hilt.di

import com.example.mvvm_hilt.repo.MainRepo
import com.example.mvvm_hilt.retrofit.BlogRetrofit
import com.example.mvvm_hilt.retrofit.NetworkMapper
import com.example.mvvm_hilt.room.BlogDao
import com.example.mvvm_hilt.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent ::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepo(
        blogDao: BlogDao,
        blogRetrofit: BlogRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepo {
        return MainRepo(blogRetrofit, blogDao, cacheMapper, networkMapper)
    }
}
package com.example.becomingdev.base

import com.example.becomingdev.data.api.HomeApi
import com.example.becomingdev.domain.repository.HomeRepository
import com.example.becomingdev.repository.HomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideHomeRepository(homeApi: HomeApi): HomeRepository{
        return HomeRepositoryImpl(homeApi)
    }
}
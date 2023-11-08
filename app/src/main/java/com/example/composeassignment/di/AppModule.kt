package com.example.composeassignment.di

import com.example.composeassignment.data.discover.impl.DiscoverRepository
import com.example.composeassignment.data.discover.impl.FakeDiscoverRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDiscoveryRepository(): DiscoverRepository {
        return FakeDiscoverRepository()
    }
}
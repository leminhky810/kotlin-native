package org.minhky.kmpnative.di

import org.minhky.kmpnative.network.KtorClient
import org.minhky.kmpnative.network.dataSource.FruittieRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesKtorClient() = KtorClient()

    @Provides
    @Singleton
    fun providesFruittieRemoteDataSource(
        ktorClient: KtorClient
    ) = FruittieRemoteDataSource(ktorClient)
}
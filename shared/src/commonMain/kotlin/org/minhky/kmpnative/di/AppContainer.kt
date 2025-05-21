package org.minhky.kmpnative.di

import org.minhky.kmpnative.data.FruittieRepositoryImpl
import org.minhky.kmpnative.domain.repository.FruittieRepository
import org.minhky.kmpnative.domain.usecase.ObserverFruittesUseCase
import org.minhky.kmpnative.network.KtorClient
import org.minhky.kmpnative.network.dataSource.FruittieRemoteDataSource

class AppContainer(
    private val appDatabaseFactory: AppDatabaseFactory
) {

    private val ktorClient: KtorClient by lazy {
        KtorClient()
    }

    val fruittesRemoteDataSource: FruittieRemoteDataSource by lazy {
        FruittieRemoteDataSource(ktorClient)
    }

    val fruittieRepository: FruittieRepository by lazy {
        FruittieRepositoryImpl(
            fruittesRemoteDataSource = fruittesRemoteDataSource,
            appDatabaseFactory = appDatabaseFactory
        )
    }
    val observerFruittesUseCase: ObserverFruittesUseCase by lazy {
        ObserverFruittesUseCase(fruittieRepository)
    }
}

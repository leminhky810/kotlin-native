package org.minhky.kmpnative.di

import org.minhky.kmpnative.data.FruittieRepositoryImpl
import org.minhky.kmpnative.domain.repository.FruittieRepository
import org.minhky.kmpnative.network.dataSource.FruittieRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    @Provides
    @ViewModelScoped
    fun providesFruitteRepository(
        fruittesRemoteDataSource: FruittieRemoteDataSource,
        appDatabaseFactory: AppDatabaseFactory
    ): FruittieRepository =
        FruittieRepositoryImpl(
            fruittesRemoteDataSource = fruittesRemoteDataSource,
            appDatabaseFactory = appDatabaseFactory
        )
}
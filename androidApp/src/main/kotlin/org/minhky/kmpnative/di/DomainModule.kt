package org.minhky.kmpnative.di

import org.minhky.kmpnative.domain.repository.FruittieRepository
import org.minhky.kmpnative.domain.usecase.ObserverFruittesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    @ViewModelScoped
    fun providesObserveFruitteUseCase(
        fruittieRepository: FruittieRepository
    ) = ObserverFruittesUseCase(fruittieRepository)

}
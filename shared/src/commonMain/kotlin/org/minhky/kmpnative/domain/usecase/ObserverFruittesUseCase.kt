package org.minhky.kmpnative.domain.usecase

import org.minhky.kmpnative.domain.model.Fruittie
import org.minhky.kmpnative.domain.repository.FruittieRepository
import kotlinx.coroutines.flow.Flow

class ObserverFruittesUseCase(private val repository: FruittieRepository) {
    operator fun invoke(): Flow<List<Fruittie>> {
        return repository.observeFruitties()
    }
} 
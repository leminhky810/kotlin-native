package org.minhky.kmpnative.domain.usecase

import org.minhky.kmpnative.domain.model.Fruittie
import org.minhky.kmpnative.domain.repository.FruittieRepository

class GetFruittesUseCase(private val repository: FruittieRepository) {
    suspend operator fun invoke(page: Int): List<Fruittie> {
        return repository.getFruitties(page)
    }
} 
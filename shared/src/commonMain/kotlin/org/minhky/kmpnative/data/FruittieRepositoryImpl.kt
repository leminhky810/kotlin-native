package org.minhky.kmpnative.data

import org.minhky.kmpnative.data.mapper.toDomain
import org.minhky.kmpnative.data.mapper.toEntity
import org.minhky.kmpnative.di.AppDatabaseFactory
import org.minhky.kmpnative.di.fruitteeDao
import org.minhky.kmpnative.domain.model.Fruittie
import org.minhky.kmpnative.domain.repository.FruittieRepository
import org.minhky.kmpnative.network.dataSource.FruittieRemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class FruittieRepositoryImpl(
    private val fruittesRemoteDataSource: FruittieRemoteDataSource,
    appDatabaseFactory: AppDatabaseFactory
) : FruittieRepository {

    private val fruitteeDao = appDatabaseFactory.fruitteeDao

    override suspend fun getFruitties(page: Int): List<Fruittie> {
        return try {
            // Get from remote
            val fruittes = fruittesRemoteDataSource.getFruitties(page).feed
            // Store in local
            val ids = fruitteeDao.insertFruittes(fruittes.toEntity())
            fruittes.toDomain(ids)
        } catch (e: Exception) {
            // If remote fails, get from local
            fruitteeDao.getAllFruittes().toDomain()
        }
    }

    override fun observeFruitties(): Flow<List<Fruittie>> {
        CoroutineScope(Dispatchers.IO).launch {
            if (fruitteeDao.count() < 1) {
                getFruitties(0)
            }
        }
        return fruitteeDao.observeFruittes().map { it.toDomain() }
    }

    override suspend fun deleteFruittie(id: String) {
        fruitteeDao.deleteFruitte(id)
    }

    override suspend fun clearFruitties() {
        fruitteeDao.deleteAllFruittes()
    }

}
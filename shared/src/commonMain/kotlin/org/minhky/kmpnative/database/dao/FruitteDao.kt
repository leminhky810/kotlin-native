package org.minhky.kmpnative.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.minhky.kmpnative.database.entity.FruittieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FruitteDao {
    @Query("SELECT * FROM fruitties")
    fun observeFruittes(): Flow<List<FruittieEntity>>

    @Query("SELECT * FROM fruitties")
    suspend fun getAllFruittes(): List<FruittieEntity>

    @Query("SELECT * FROM fruitties WHERE id = :id")
    suspend fun getFruitteById(id: String): FruittieEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFruitte(user: FruittieEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFruittes(fruitties: List<FruittieEntity>): List<Long>

    @Query("DELETE FROM fruitties WHERE id = :id")
    suspend fun deleteFruitte(id: String)

    @Query("DELETE FROM fruitties")
    suspend fun deleteAllFruittes()

    @Query("SELECT COUNT(*) as count FROM fruitties")
    suspend fun count(): Int

} 
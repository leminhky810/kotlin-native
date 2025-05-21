package org.minhky.kmpnative.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import org.minhky.kmpnative.database.entity.FruittieEntity
import org.minhky.kmpnative.database.dao.FruitteDao

@Database(
    entities = [FruittieEntity::class],
    version = 1
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun fruitteeDao(): FruitteDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}

internal const val DB_FILE_NAME = "demo.db"
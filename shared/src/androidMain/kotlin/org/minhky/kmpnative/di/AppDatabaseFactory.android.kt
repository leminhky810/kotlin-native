package org.minhky.kmpnative.di

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import org.minhky.kmpnative.database.AppDatabase
import org.minhky.kmpnative.database.DB_FILE_NAME

actual class AppDatabaseFactory(
    private val context: Context
) {
    actual fun createAppDatabase(): AppDatabase =
        Room
            .databaseBuilder<AppDatabase>(
                context = context,
                name = context.getDatabasePath(DB_FILE_NAME).absolutePath,
            ).setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
}
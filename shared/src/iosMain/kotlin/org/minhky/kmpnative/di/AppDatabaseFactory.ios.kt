package org.minhky.kmpnative.di

import androidx.room.Room
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import org.minhky.kmpnative.database.AppDatabase
import org.minhky.kmpnative.database.DB_FILE_NAME

actual class AppDatabaseFactory {
    actual fun createAppDatabase(): AppDatabase =
        Room.databaseBuilder<AppDatabase>(
            name = "${fileDirectory()}/$DB_FILE_NAME",
        ).setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()


    @OptIn(ExperimentalForeignApi::class)
    private fun fileDirectory(): String {
        val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null,
        )
        return requireNotNull(documentDirectory).path!!
    }
}
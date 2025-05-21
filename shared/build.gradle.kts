import com.android.build.api.dsl.androidLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKmpLibrary)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
}

kotlin {

    androidLibrary {
        namespace = "org.minhky.kmpnative.shared"
        compileSdk = libs.versions.androidCompileSdk.get().toInt()
        minSdk = libs.versions.androidMinSdk.get().toInt()
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }
    
    sourceSets {
        all {
            languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
        }
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.datetime)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.androidx.lifecycle.viewmodel)

            // Ktor
            implementation(libs.ktor.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.client.logging)

            // Room
            implementation(libs.room.runtime)
            implementation(libs.sqlite.bundled)

            // Data Store
            api(libs.datastore.preferences.core)
            api(libs.datastore.core.okio)
            implementation(libs.okio)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.kotlinx.coroutines.test)
        }
        androidMain.dependencies {
            // Add Android-specific dependencies here. Note that this source set depends on
            // commonMain by default and will correctly pull the Android artifacts of any KMP
            // dependencies declared in commonMain.
            implementation(libs.kotlinx.coroutines.android)
            implementation(libs.ktor.client.okhttp)
        }
        iosMain.dependencies {
            // Add iOS-specific dependencies here. This a source set created by Kotlin Gradle
            // Plugin (KGP) that each specific iOS target (e.g., iosX64) depends on as
            // part of KMP's default source set hierarchy. Note that this source set depends
            // on common by default and will correctly pull the iOS artifacts of any
            // KMP dependencies declared in commonMain.
            implementation(libs.ktor.client.darwin)
        }
    }
}

dependencies {
    add("kspAndroid", libs.room.compiler)
    add("kspIosSimulatorArm64", libs.room.compiler)
    add("kspIosX64", libs.room.compiler)
    add("kspIosArm64", libs.room.compiler)
}

room {
    schemaDirectory("$projectDir/schemas")
}
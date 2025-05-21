package org.minhky.kmpnative

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
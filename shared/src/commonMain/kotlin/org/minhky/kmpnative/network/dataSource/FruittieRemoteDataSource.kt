package org.minhky.kmpnative.network.dataSource

import org.minhky.kmpnative.API_URL
import org.minhky.kmpnative.network.model.FruittiesResponse
import org.minhky.kmpnative.network.KtorClient
import io.ktor.client.call.*
import io.ktor.client.request.*

class FruittieRemoteDataSource(private val client: KtorClient) {
    private val baseUrl = API_URL

    suspend fun getFruitties(page: Int): FruittiesResponse {
        return client.httpClient.get("$baseUrl/$page.json").body<FruittiesResponse>()
    }

} 
package org.minhky.kmpnative.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FruittiesResponse(
    @SerialName("feed")
    val feed: List<FruittieDto>,
    @SerialName("totalPages")
    val totalPages: Int,
    @SerialName("currentPage")
    val currentPage: Int,
)
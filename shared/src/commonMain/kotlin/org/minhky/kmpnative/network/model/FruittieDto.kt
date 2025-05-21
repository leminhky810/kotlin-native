package org.minhky.kmpnative.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FruittieDto(
    @SerialName("name")
    val name: String,
    @SerialName("full_name")
    val fullName: String,
    @SerialName("calories")
    val calories: String,
)

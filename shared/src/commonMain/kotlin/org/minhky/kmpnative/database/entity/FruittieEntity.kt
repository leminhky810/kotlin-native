package org.minhky.kmpnative.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.minhky.kmpnative.domain.model.Fruittie
import org.minhky.kmpnative.network.model.FruittieDto

@Entity(tableName = "fruitties")
data class FruittieEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val fullName: String,
    val calories: String,
)
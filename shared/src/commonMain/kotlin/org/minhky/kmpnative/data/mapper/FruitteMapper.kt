package org.minhky.kmpnative.data.mapper

import org.minhky.kmpnative.database.entity.FruittieEntity
import org.minhky.kmpnative.domain.model.Fruittie
import org.minhky.kmpnative.network.model.FruittieDto

fun FruittieEntity.toDomain(): Fruittie {
    return Fruittie(
        id = id,
        name = name,
        fullName = fullName,
        calories = calories
    )
}
fun List<FruittieEntity>.toDomain(): List<Fruittie> = map { it.toDomain() }


fun FruittieDto.toEntity(): FruittieEntity {
    return FruittieEntity(
        name = name,
        fullName = fullName,
        calories = calories
    )
}
fun List<FruittieDto>.toEntity(): List<FruittieEntity> = map { it.toEntity() }

fun FruittieDto.toDomain(id: Long): Fruittie {
    return Fruittie(
        id = id,
        name = name,
        fullName = fullName,
        calories = calories
    )
}
fun List<FruittieDto>.toDomain(ids: List<Long>): List<Fruittie> =
    mapIndexed { index, item ->
        item.toDomain(ids[index])
    }


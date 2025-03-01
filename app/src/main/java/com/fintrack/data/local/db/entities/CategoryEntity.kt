package com.fintrack.data.local.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by fasil on 01/03/25.
 */
@Entity(tableName = "category")
data class CategoryEntity(
    @PrimaryKey
    val categoryId: Long,
    val name: String,
    val color: String? = null
)

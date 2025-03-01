package com.fintrack.data.local.db.entities

/**
 * Created by fasil on 01/03/25.
 */
data class CategoryWithTotalSpent(
    val categoryId: Long,
    val name: String,
    val color: String?,
    val totalSpent: Double
)
package com.fintrack.data.local.db.entities

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Created by fasil on 01/03/25.
 */
data class ExpenseWithCategory(
    @Embedded val expense: ExpenseEntity,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "categoryId"
    )
    val category: CategoryEntity
)

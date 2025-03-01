package com.fintrack.data.local.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by fasil on 01/03/25.
 */
@Entity(tableName = "budget")
data class BudgetEntity(
    @PrimaryKey
    val id: Long,
    val amount: Double,
    val categoryId: Long,
    val date: Long
)

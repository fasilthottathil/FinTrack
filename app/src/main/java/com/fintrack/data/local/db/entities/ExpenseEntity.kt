package com.fintrack.data.local.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by fasil on 01/03/25.
 */
@Entity(tableName = "expense")
data class ExpenseEntity(
    @PrimaryKey
    val id: Long,
    val title: String,
    val amount: Double,
    val categoryId: Long,
    val date: Long
)

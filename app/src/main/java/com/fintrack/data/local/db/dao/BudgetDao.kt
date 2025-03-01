package com.fintrack.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.fintrack.data.local.db.entities.BudgetEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by fasil on 01/03/25.
 */
@Dao
interface BudgetDao {
    @Upsert
    suspend fun upsertBudget(budgetEntity: BudgetEntity)

    @Query("SELECT SUM(amount) FROM budget WHERE date >= :startOfMonth AND date <= :endOfMonth")
    fun getTotalBudgetForDateRange(
        startOfMonth: Long,
        endOfMonth: Long
    ): Flow<Double>
}
package com.fintrack.data.repository

import com.fintrack.data.local.db.AppDatabase
import com.fintrack.data.local.db.entities.BudgetEntity
import com.fintrack.domain.repository.BudgetRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by fasil on 01/03/25.
 */
class BudgetRepositoryImpl(private val appDatabase: AppDatabase): BudgetRepository {
    override suspend fun addBudget(amount: Double, categoryId: Long) {
        val now = System.currentTimeMillis()
        val budgetEntity = BudgetEntity(
            id = now,
            amount = amount,
            categoryId = categoryId,
            date = now
        )
        appDatabase.budgetDao().upsertBudget(budgetEntity)
    }

    override fun getTotalBudgetForDateRange(start: Long, end: Long): Flow<Double> {
        return appDatabase.budgetDao().getTotalBudgetForDateRange(start, end)
    }
}
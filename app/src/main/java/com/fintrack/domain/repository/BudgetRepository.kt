package com.fintrack.domain.repository

import kotlinx.coroutines.flow.Flow

/**
 * Created by fasil on 01/03/25.
 */
interface BudgetRepository {
    suspend fun addBudget(amount: Double, categoryId: Long)
    fun getTotalBudgetForDateRange(start: Long, end: Long): Flow<Double>
}
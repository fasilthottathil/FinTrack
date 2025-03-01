package com.fintrack.domain.repository

import com.fintrack.data.local.db.entities.ExpenseEntity
import com.fintrack.data.local.db.entities.ExpenseWithCategory
import kotlinx.coroutines.flow.Flow

/**
 * Created by fasil on 01/03/25.
 */
interface ExpenseRepository {
    suspend fun addExpense(amount: Double, title: String, categoryId: Long)
    suspend fun deleteExpense(expenseEntity: ExpenseEntity)
    fun getAllExpenses(): Flow<List<ExpenseWithCategory>>
    fun getTotalSpentByDateRange(start: Long, end: Long): Flow<Double>
    suspend fun getExpensesByDateRange(start: Long, end: Long): Flow<List<ExpenseWithCategory>>
    fun getRecent5Expenses(): Flow<List<ExpenseWithCategory>>
}
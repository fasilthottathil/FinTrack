package com.fintrack.data.repository

import com.fintrack.data.local.db.AppDatabase
import com.fintrack.data.local.db.entities.ExpenseEntity
import com.fintrack.data.local.db.entities.ExpenseWithCategory
import com.fintrack.domain.repository.ExpenseRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by fasil on 01/03/25.
 */
class ExpenseRepositoryImpl(private val appDatabase: AppDatabase) : ExpenseRepository {
    override suspend fun addExpense(amount: Double, title: String, categoryId: Long) {
        val now = System.currentTimeMillis()
        val expenseEntity = ExpenseEntity(
            id = now,
            title = title,
            amount = amount,
            categoryId = categoryId,
            date = now
        )
        appDatabase.expenseDao().upsertExpense(expenseEntity)
    }

    override suspend fun deleteExpense(expenseEntity: ExpenseEntity) {
        appDatabase.expenseDao().deleteExpense(expenseEntity)
    }

    override fun getAllExpenses(): Flow<List<ExpenseWithCategory>> {
        return appDatabase.expenseDao().getExpensesWithCategory()
    }

    override fun getTotalSpentByDateRange(start: Long, end: Long): Flow<Double> {
        return appDatabase.expenseDao().getTotalSpentByDateRange(start, end)
    }

    override suspend fun getExpensesByDateRange(
        start: Long,
        end: Long
    ): Flow<List<ExpenseWithCategory>> {
        return appDatabase.expenseDao().getExpensesByDateRange(start, end)
    }

    override fun getRecent5Expenses(): Flow<List<ExpenseWithCategory>> {
        return appDatabase.expenseDao().getRecent5ExpensesWithCategory()
    }
}
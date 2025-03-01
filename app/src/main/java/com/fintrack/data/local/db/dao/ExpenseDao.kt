package com.fintrack.data.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.fintrack.data.local.db.entities.ExpenseEntity
import com.fintrack.data.local.db.entities.ExpenseWithCategory
import kotlinx.coroutines.flow.Flow

/**
 * Created by fasil on 01/03/25.
 */
@Dao
interface ExpenseDao {

    @Upsert
    suspend fun upsertExpense(expense: ExpenseEntity)

    @Delete
    suspend fun deleteExpense(expense: ExpenseEntity)

    @Transaction
    @Query("SELECT * FROM expense")
    fun getExpensesWithCategory(): Flow<List<ExpenseWithCategory>>

    @Transaction
    @Query("SELECT * FROM expense ORDER BY date DESC LIMIT 5")
    fun getRecent5ExpensesWithCategory(): Flow<List<ExpenseWithCategory>>

    @Query("SELECT * FROM expense WHERE date >= :startOfMonth AND date <= :endOfMonth")
    fun getExpensesByDateRange(
        startOfMonth: Long,
        endOfMonth: Long
    ): Flow<List<ExpenseWithCategory>>

    @Query("SELECT SUM(amount) FROM expense WHERE date >= :startOfMonth AND date <= :endOfMonth")
    fun getTotalSpentByDateRange(
        startOfMonth: Long,
        endOfMonth: Long
    ): Flow<Double>

}
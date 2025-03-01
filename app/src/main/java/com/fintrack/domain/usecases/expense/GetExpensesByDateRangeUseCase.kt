package com.fintrack.domain.usecases.expense

import com.fintrack.data.local.db.entities.ExpenseWithCategory
import com.fintrack.domain.repository.ExpenseRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by fasil on 01/03/25.
 */
class GetExpensesByDateRangeUseCase(
    private val expenseRepository: ExpenseRepository
) {
    suspend operator fun invoke(start: Long, end: Long): Flow<List<ExpenseWithCategory>> {
        return expenseRepository.getExpensesByDateRange(start, end)
    }
}
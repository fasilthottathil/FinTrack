package com.fintrack.domain.usecases.expense

import com.fintrack.domain.repository.ExpenseRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by fasil on 01/03/25.
 */
class GetTotalSpentByDateRangeUseCase(
    private val expenseRepository: ExpenseRepository
) {
    operator fun invoke(start: Long, end: Long): Flow<Double> {
        return expenseRepository.getTotalSpentByDateRange(start, end)
    }
}
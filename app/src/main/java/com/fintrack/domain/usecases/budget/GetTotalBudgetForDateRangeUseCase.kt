package com.fintrack.domain.usecases.budget

import com.fintrack.domain.repository.BudgetRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by fasil on 01/03/25.
 */

class GetTotalBudgetForDateRangeUseCase(
    private val budgetRepository: BudgetRepository
) {
    operator fun invoke(start: Long, end: Long): Flow<Double> {
        return budgetRepository.getTotalBudgetForDateRange(start, end)
    }
}
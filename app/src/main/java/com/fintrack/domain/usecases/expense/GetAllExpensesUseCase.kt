package com.fintrack.domain.usecases.expense

import com.fintrack.data.local.db.entities.ExpenseWithCategory
import com.fintrack.domain.repository.ExpenseRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by fasil on 01/03/25.
 */
class GetAllExpensesUseCase(
    private val expenseRepository: ExpenseRepository
) {
    operator fun invoke(): Flow<List<ExpenseWithCategory>> {
        return expenseRepository.getAllExpenses()
    }
}
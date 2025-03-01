package com.fintrack.domain.usecases.expense

import com.fintrack.data.local.db.entities.ExpenseEntity
import com.fintrack.domain.repository.ExpenseRepository

/**
 * Created by fasil on 01/03/25.
 */
class DeleteExpenseUseCase(
    private val expenseRepository: ExpenseRepository
) {
    suspend operator fun invoke(expenseEntity: ExpenseEntity) {
        expenseRepository.deleteExpense(expenseEntity)
    }
}
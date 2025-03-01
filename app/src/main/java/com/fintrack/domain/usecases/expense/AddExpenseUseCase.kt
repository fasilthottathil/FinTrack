package com.fintrack.domain.usecases.expense

import com.fintrack.domain.repository.ExpenseRepository

/**
 * Created by fasil on 01/03/25.
 */
class AddExpenseUseCase(
    private val expenseRepository: ExpenseRepository
) {
    suspend operator fun invoke(amount: Double, title: String, categoryId: Long) {
        expenseRepository.addExpense(amount, title, categoryId)
    }
}
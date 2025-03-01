package com.fintrack.domain.usecases.budget

import com.fintrack.domain.repository.BudgetRepository

/**
 * Created by fasil on 01/03/25.
 */
class AddBudgetUseCase(
    private val budgetRepository: BudgetRepository
) {
    suspend operator fun invoke(amount: Double, categoryId: Long) {
        budgetRepository.addBudget(amount, categoryId)
    }
}
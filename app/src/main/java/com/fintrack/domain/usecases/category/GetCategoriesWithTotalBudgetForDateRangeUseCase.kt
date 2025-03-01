package com.fintrack.domain.usecases.category

import com.fintrack.data.local.db.entities.CategoryWithTotalBudget
import com.fintrack.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by fasil on 01/03/25.
 */
class GetCategoriesWithTotalBudgetForDateRangeUseCase(
    private val categoryRepository: CategoryRepository
) {
    operator fun invoke(start: Long, end: Long): Flow<List<CategoryWithTotalBudget>> {
        return categoryRepository.getCategoriesWithTotalBudgetForDateRange(start, end)
    }
}
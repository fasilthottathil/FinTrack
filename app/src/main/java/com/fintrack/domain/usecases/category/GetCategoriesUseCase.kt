package com.fintrack.domain.usecases.category

import com.fintrack.data.local.db.entities.CategoryEntity
import com.fintrack.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by fasil on 01/03/25.
 */
class GetCategoriesUseCase(
    private val categoryRepository: CategoryRepository
) {
     operator fun invoke(): Flow<List<CategoryEntity>> {
        return categoryRepository.getCategories()
    }
}
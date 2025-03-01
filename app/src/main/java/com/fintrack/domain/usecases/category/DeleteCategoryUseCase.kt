package com.fintrack.domain.usecases.category

import com.fintrack.data.local.db.entities.CategoryEntity
import com.fintrack.domain.repository.CategoryRepository

/**
 * Created by fasil on 01/03/25.
 */
class DeleteCategoryUseCase(
    private val categoryRepository: CategoryRepository
) {
    suspend operator fun invoke(categoryEntity: CategoryEntity) {
        categoryRepository.deleteCategory(categoryEntity)
    }
}
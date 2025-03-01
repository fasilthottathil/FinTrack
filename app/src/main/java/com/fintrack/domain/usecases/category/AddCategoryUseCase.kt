package com.fintrack.domain.usecases.category

import com.fintrack.domain.repository.CategoryRepository

/**
 * Created by fasil on 01/03/25.
 */
class AddCategoryUseCase(
    private val categoryRepository: CategoryRepository
) {
    suspend operator fun invoke(name: String, color: String?) {
        categoryRepository.addCategory(name, color)
    }
}
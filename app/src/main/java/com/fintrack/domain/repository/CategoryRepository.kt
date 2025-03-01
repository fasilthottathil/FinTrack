package com.fintrack.domain.repository

import com.fintrack.data.local.db.entities.CategoryEntity
import com.fintrack.data.local.db.entities.CategoryWithTotalBudget
import com.fintrack.data.local.db.entities.CategoryWithTotalSpent
import kotlinx.coroutines.flow.Flow

/**
 * Created by fasil on 01/03/25.
 */
interface CategoryRepository {
    suspend fun addCategory(name: String, color: String? = null)
    suspend fun deleteCategory(categoryEntity: CategoryEntity)
    fun getCategories(): Flow<List<CategoryEntity>>
    suspend fun getCategoryById(id: String): CategoryEntity?
    fun getCategoriesWithTotalBudgetForDateRange(
        start: Long,
        end: Long
    ): Flow<List<CategoryWithTotalBudget>>
    fun getCategoriesWithTotalSpentForDateRange(
        start: Long,
        end: Long
    ): Flow<List<CategoryWithTotalSpent>>
}
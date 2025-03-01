package com.fintrack.data.repository

import com.fintrack.data.local.db.AppDatabase
import com.fintrack.data.local.db.entities.CategoryEntity
import com.fintrack.data.local.db.entities.CategoryWithTotalBudget
import com.fintrack.data.local.db.entities.CategoryWithTotalSpent
import com.fintrack.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by fasil on 01/03/25.
 */
class CategoryRepositoryImpl(private val appDatabase: AppDatabase) : CategoryRepository {
    override suspend fun addCategory(name: String, color: String?) {
        val categoryEntity = CategoryEntity(
            categoryId = System.currentTimeMillis(),
            name = name,
            color = color
        )
        appDatabase.categoryDao().upsertCategory(categoryEntity)
    }

    override suspend fun deleteCategory(categoryEntity: CategoryEntity) {
        appDatabase.categoryDao().deleteCategory(categoryEntity)
    }

    override fun getCategories(): Flow<List<CategoryEntity>> {
        return appDatabase.categoryDao().getCategories()
    }

    override suspend fun getCategoryById(id: String): CategoryEntity? {
        return appDatabase.categoryDao().getCategoryById(id)
    }

    override fun getCategoriesWithTotalBudgetForDateRange(
        start: Long,
        end: Long
    ): Flow<List<CategoryWithTotalBudget>> {
        return appDatabase.categoryDao().getCategoriesWithTotalBudgetForDateRange(start, end)
    }

    override fun getCategoriesWithTotalSpentForDateRange(
        start: Long,
        end: Long
    ): Flow<List<CategoryWithTotalSpent>> {
        return appDatabase.categoryDao().getCategoriesWithTotalSpentForDateRange(start, end)
    }
}
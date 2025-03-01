package com.fintrack.data.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.fintrack.data.local.db.entities.CategoryEntity
import com.fintrack.data.local.db.entities.CategoryWithTotalBudget
import com.fintrack.data.local.db.entities.CategoryWithTotalSpent
import kotlinx.coroutines.flow.Flow

/**
 * Created by fasil on 01/03/25.
 */
@Dao
interface CategoryDao {
    @Upsert
    suspend fun upsertCategory(categoryEntity: CategoryEntity)

    @Delete
    suspend fun deleteCategory(categoryEntity: CategoryEntity)

    @Query("SELECT * FROM category ORDER BY categoryId DESC")
    fun getCategories(): Flow<List<CategoryEntity>>

    @Query("SELECT * FROM category WHERE categoryId = :id")
    fun getCategoryById(id: String): CategoryEntity?

    @Query("""
        SELECT c.categoryId, c.name, c.color, SUM(b.amount) as totalBudget
        FROM category c
        LEFT JOIN budget b ON c.categoryId = b.categoryId
        WHERE b.date >= :startOfMonth AND b.date <= :endOfMonth
        GROUP BY c.categoryId
    """)
    fun getCategoriesWithTotalBudgetForDateRange(
        startOfMonth: Long,
        endOfMonth: Long
    ): Flow<List<CategoryWithTotalBudget>>

    @Query("""
        SELECT c.categoryId, c.name, c.color, SUM(e.amount) as totalSpent
        FROM category c
        LEFT JOIN expense e ON c.categoryId = e.categoryId
        WHERE e.date >= :startOfMonth AND e.date <= :endOfMonth
        GROUP BY c.categoryId
    """)
    fun getCategoriesWithTotalSpentForDateRange(
        startOfMonth: Long,
        endOfMonth: Long
    ): Flow<List<CategoryWithTotalSpent>>

}
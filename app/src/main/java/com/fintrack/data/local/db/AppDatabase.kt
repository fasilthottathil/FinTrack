package com.fintrack.data.local.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fintrack.data.local.db.dao.BudgetDao
import com.fintrack.data.local.db.dao.CategoryDao
import com.fintrack.data.local.db.dao.ExpenseDao
import com.fintrack.data.local.db.entities.BudgetEntity
import com.fintrack.data.local.db.entities.CategoryEntity
import com.fintrack.data.local.db.entities.ExpenseEntity

/**
 * Created by fasil on 01/03/25.
 */
@Database(
    entities = [ExpenseEntity::class, CategoryEntity::class, BudgetEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao
    abstract fun categoryDao(): CategoryDao
    abstract fun budgetDao(): BudgetDao

    companion object {
        fun getInstance(application: Application): AppDatabase {
            return Room.databaseBuilder(
                context = application,
                klass = AppDatabase::class.java,
                name = "fin-track.db"
            ).build()
        }
    }
}
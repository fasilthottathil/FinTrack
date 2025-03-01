package com.fintrack.di

import com.fintrack.data.repository.BudgetRepositoryImpl
import com.fintrack.data.repository.CategoryRepositoryImpl
import com.fintrack.data.repository.ExpenseRepositoryImpl
import com.fintrack.domain.repository.BudgetRepository
import com.fintrack.domain.repository.CategoryRepository
import com.fintrack.domain.repository.ExpenseRepository
import org.koin.dsl.module

/**
 * Created by fasil on 01/03/25.
 */
val repositoryModule = module {
    factory <ExpenseRepository>{ ExpenseRepositoryImpl(get()) }
    factory <CategoryRepository>{ CategoryRepositoryImpl(get()) }
    factory <BudgetRepository>{ BudgetRepositoryImpl(get()) }
}
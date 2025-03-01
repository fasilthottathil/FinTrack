package com.fintrack.di

import com.fintrack.presentation.analytics.AnalyticsViewModel
import com.fintrack.presentation.budget.BudgetViewModel
import com.fintrack.presentation.category.add.AddCategoryViewModel
import com.fintrack.presentation.category.categories.CategoriesViewModel
import com.fintrack.presentation.expense.add.AddExpenseViewModel
import com.fintrack.presentation.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by fasil on 01/03/25.
 */
val viewModelModule = module {
    viewModel { AddCategoryViewModel(get(), get()) }
    viewModel { CategoriesViewModel(get()) }
    viewModel { AddExpenseViewModel(get(), get(), get()) }
    viewModel { BudgetViewModel(get(), get(), get()) }
    viewModel { HomeViewModel(get(), get(), get()) }
    viewModel { AnalyticsViewModel(get(), get()) }
}
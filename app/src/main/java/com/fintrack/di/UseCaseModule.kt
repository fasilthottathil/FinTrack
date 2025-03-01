package com.fintrack.di

import com.fintrack.domain.usecases.budget.AddBudgetUseCase
import com.fintrack.domain.usecases.budget.GetTotalBudgetForDateRangeUseCase
import com.fintrack.domain.usecases.category.AddCategoryUseCase
import com.fintrack.domain.usecases.category.DeleteCategoryUseCase
import com.fintrack.domain.usecases.category.GetCategoriesUseCase
import com.fintrack.domain.usecases.category.GetCategoriesWithTotalBudgetForDateRangeUseCase
import com.fintrack.domain.usecases.category.GetCategoriesWithTotalSpentByDateRangeUseCase
import com.fintrack.domain.usecases.category.GetCategoryByIdUseCase
import com.fintrack.domain.usecases.expense.AddExpenseUseCase
import com.fintrack.domain.usecases.expense.DeleteExpenseUseCase
import com.fintrack.domain.usecases.expense.GetAllExpensesUseCase
import com.fintrack.domain.usecases.expense.GetExpensesByDateRangeUseCase
import com.fintrack.domain.usecases.expense.GetRecent5ExpensesUseCase
import com.fintrack.domain.usecases.expense.GetTotalSpentByDateRangeUseCase
import org.koin.dsl.module

/**
 * Created by fasil on 01/03/25.
 */
val useCaseModule = module {
    //expense
    factory { AddExpenseUseCase(get()) }
    factory { DeleteExpenseUseCase(get()) }
    factory { GetAllExpensesUseCase(get()) }
    factory { GetExpensesByDateRangeUseCase(get()) }
    factory { GetRecent5ExpensesUseCase(get()) }
    factory { GetTotalSpentByDateRangeUseCase(get()) }

    //category
    factory { AddCategoryUseCase(get()) }
    factory { DeleteCategoryUseCase(get()) }
    factory { GetCategoriesUseCase(get()) }
    factory { GetCategoryByIdUseCase(get()) }
    factory { GetCategoriesWithTotalBudgetForDateRangeUseCase(get()) }
    factory { GetCategoriesWithTotalSpentByDateRangeUseCase(get()) }

    //budget
    factory { AddBudgetUseCase(get()) }
    factory { GetTotalBudgetForDateRangeUseCase(get()) }


}
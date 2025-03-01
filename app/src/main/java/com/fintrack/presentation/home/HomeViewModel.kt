package com.fintrack.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fintrack.domain.usecases.budget.GetTotalBudgetForDateRangeUseCase
import com.fintrack.domain.usecases.expense.GetRecent5ExpensesUseCase
import com.fintrack.domain.usecases.expense.GetTotalSpentByDateRangeUseCase
import com.fintrack.util.getStartAndEndOfCurrentMonth
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

/**
 * Created by fasil on 01/03/25.
 */
class HomeViewModel(
    getTotalBudgetForDateRangeUseCase: GetTotalBudgetForDateRangeUseCase,
    getTotalSpentByDateRangeUseCase: GetTotalSpentByDateRangeUseCase,
    getRecent5ExpensesUseCase: GetRecent5ExpensesUseCase
) : ViewModel() {
    val totalBudget = getTotalBudgetForDateRangeUseCase(
        getStartAndEndOfCurrentMonth().first,
        getStartAndEndOfCurrentMonth().second
    ).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = 0.0
    )
    val totalSpent = getTotalSpentByDateRangeUseCase(
        getStartAndEndOfCurrentMonth().first,
        getStartAndEndOfCurrentMonth().second
    ).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = 0.0
    )

    val recent5Expenses = getRecent5ExpensesUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )

}
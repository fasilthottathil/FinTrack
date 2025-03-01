package com.fintrack.presentation.analytics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fintrack.domain.usecases.category.GetCategoriesWithTotalBudgetForDateRangeUseCase
import com.fintrack.domain.usecases.category.GetCategoriesWithTotalSpentByDateRangeUseCase
import com.fintrack.util.getStartAndEndOfCurrentMonth
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

/**
 * Created by fasil on 01/03/25.
 */
class AnalyticsViewModel(
    getCategoriesWithTotalBudgetForDateRangeUseCase: GetCategoriesWithTotalBudgetForDateRangeUseCase,
    getCategoriesWithTotalSpentByDateRangeUseCase: GetCategoriesWithTotalSpentByDateRangeUseCase
) : ViewModel() {
    val categoryWithBudget = getCategoriesWithTotalBudgetForDateRangeUseCase(
        getStartAndEndOfCurrentMonth().first,
        getStartAndEndOfCurrentMonth().second
    ).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()

    )
    val categoryWithSpent = getCategoriesWithTotalSpentByDateRangeUseCase(
        getStartAndEndOfCurrentMonth().first,
        getStartAndEndOfCurrentMonth().second
    ).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()

    )
}
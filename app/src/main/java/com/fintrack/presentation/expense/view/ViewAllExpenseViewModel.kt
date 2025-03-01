package com.fintrack.presentation.expense.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fintrack.domain.usecases.expense.GetAllExpensesUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

/**
 * Created by fasil on 01/03/25.
 */
class ViewAllExpenseViewModel(
    getAllExpensesUseCase: GetAllExpensesUseCase
) : ViewModel() {
    val allExpenses = getAllExpensesUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )
}
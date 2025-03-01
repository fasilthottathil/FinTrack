package com.fintrack.presentation.budget

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fintrack.common.Dispatcher
import com.fintrack.common.FTDispatcher
import com.fintrack.data.local.db.entities.CategoryEntity
import com.fintrack.domain.usecases.budget.AddBudgetUseCase
import com.fintrack.domain.usecases.category.GetCategoryByIdUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created by fasil on 01/03/25.
 */
class BudgetViewModel(
    @Dispatcher(FTDispatcher.IO)
    private val ioDispatcher: CoroutineDispatcher,
    private val addBudgetUseCase: AddBudgetUseCase,
    private val getCategoryByIdUseCase: GetCategoryByIdUseCase
) : ViewModel() {
    private val _category: MutableStateFlow<CategoryEntity?> = MutableStateFlow(null)
    val category = _category.asStateFlow()

    fun getCategoryById(id: String) {
        viewModelScope.launch(ioDispatcher) {
            _category.update { getCategoryByIdUseCase(id) }
        }
    }

    fun addBudget(amount: String) {
        viewModelScope.launch(ioDispatcher) {
            requireNotNull(category.value?.categoryId) { "Category id cannot be null" }
            addBudgetUseCase(amount.toDouble(), category.value?.categoryId!!)
            reset()
        }
    }

    private fun reset() = _category.update { null }

}
package com.fintrack.presentation.category.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fintrack.domain.usecases.category.GetCategoriesUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

/**
 * Created by fasil on 01/03/25.
 */
class CategoriesViewModel(
    getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {
    val categories = getCategoriesUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )
}
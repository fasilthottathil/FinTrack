package com.fintrack.presentation.category.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fintrack.common.Dispatcher
import com.fintrack.common.FTDispatcher
import com.fintrack.domain.usecases.category.AddCategoryUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

/**
 * Created by fasil on 01/03/25.
 */
class AddCategoryViewModel(
    @Dispatcher(FTDispatcher.IO)
    private val ioDispatcher: CoroutineDispatcher,
    private val addCategoryUseCase: AddCategoryUseCase,
) : ViewModel() {

    fun addCategory(name: String, color: String) {
        viewModelScope.launch(ioDispatcher) {
            addCategoryUseCase(name, color)
        }
    }
}
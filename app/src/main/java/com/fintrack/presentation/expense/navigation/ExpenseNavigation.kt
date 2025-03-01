package com.fintrack.presentation.expense.navigation

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fintrack.presentation.expense.add.AddExpenseScreen
import com.fintrack.presentation.expense.add.AddExpenseViewModel
import com.fintrack.util.getOnceResult
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

/**
 * Created by fasil on 01/03/25.
 */
@Serializable
data object AddExpenseRoute

fun NavGraphBuilder.addExpenseScreen(onClickCategory: () -> Unit) {
    composable<AddExpenseRoute> {
        val viewModel = koinViewModel<AddExpenseViewModel>()
        it.getOnceResult<String>("categoryId")?.let { id ->
            viewModel.getCategoryById(id)
        }
        AddExpenseScreen(
            onClickCategory = onClickCategory,
            state = viewModel.category.collectAsStateWithLifecycle(),
            onClickAdd = viewModel::addExpense
        )
    }
}
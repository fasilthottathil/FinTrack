package com.fintrack.presentation.budget.navigation

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fintrack.presentation.budget.BudgetScreen
import com.fintrack.presentation.budget.BudgetViewModel
import com.fintrack.util.getOnceResult
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

/**
 * Created by fasil on 01/03/25.
 */
@Serializable data object BudgetRoute

fun NavGraphBuilder.budgetScreen(onClickCategory: () -> Unit) {
    composable<BudgetRoute> {
        val viewModel = koinViewModel<BudgetViewModel>()
        it.getOnceResult<String>("categoryId")?.let { id ->
            viewModel.getCategoryById(id)
        }
        BudgetScreen(
            onClickCategory = onClickCategory,
            state = viewModel.category.collectAsStateWithLifecycle(),
            onClickAdd = viewModel::addBudget
        )
    }
}
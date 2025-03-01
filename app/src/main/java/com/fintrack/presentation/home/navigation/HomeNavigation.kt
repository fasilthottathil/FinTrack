package com.fintrack.presentation.home.navigation

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fintrack.presentation.home.HomeScreen
import com.fintrack.presentation.home.HomeViewModel
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

/**
 * Created by fasil on 01/03/25.
 */
@Serializable data object HomeRoute

fun NavGraphBuilder.homeScreen() {
    composable<HomeRoute> {
        val viewModel = koinViewModel<HomeViewModel>()
        HomeScreen(
            viewModel.totalSpent.collectAsStateWithLifecycle(),
            viewModel.totalBudget.collectAsStateWithLifecycle(),
            viewModel.recent5Expenses.collectAsStateWithLifecycle()
        )
    }
}
package com.fintrack.presentation.analytics.navigation

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fintrack.presentation.analytics.AnalyticsScreen
import com.fintrack.presentation.analytics.AnalyticsViewModel
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

/**
 * Created by fasil on 01/03/25.
 */
@Serializable data object AnalyticsRoute

fun NavGraphBuilder.analyticsScreen() {
    composable<AnalyticsRoute> {
        val viewModel = koinViewModel<AnalyticsViewModel>()
        AnalyticsScreen(
            viewModel.categoryWithBudget.collectAsStateWithLifecycle(),
            viewModel.categoryWithSpent.collectAsStateWithLifecycle()
        )
    }
}
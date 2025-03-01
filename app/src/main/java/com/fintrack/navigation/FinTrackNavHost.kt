package com.fintrack.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.fintrack.presentation.analytics.navigation.analyticsScreen
import com.fintrack.presentation.budget.navigation.budgetScreen
import com.fintrack.presentation.category.navigation.addCategoryScreen
import com.fintrack.presentation.category.navigation.categoriesScreen
import com.fintrack.presentation.category.navigation.navigateToAddCategoryScreen
import com.fintrack.presentation.category.navigation.navigateToCategoriesScreen
import com.fintrack.presentation.expense.navigation.addExpenseScreen
import com.fintrack.presentation.expense.navigation.navigateToViewAllExpenseScreen
import com.fintrack.presentation.expense.navigation.viewAllExpenseScreen
import com.fintrack.presentation.home.navigation.HomeRoute
import com.fintrack.presentation.home.navigation.homeScreen

/**
 * Created by fasil on 01/03/25.
 */
@Composable
fun FinTrackNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = HomeRoute
    ) {
        homeScreen(onClickViewAll = { navHostController.navigateToViewAllExpenseScreen() })
        analyticsScreen()
        addExpenseScreen(
            onClickCategory = {
                navHostController.navigateToCategoriesScreen()
            }
        )
        budgetScreen(
            onClickCategory = {
                navHostController.navigateToCategoriesScreen()
            }
        )
        categoriesScreen(
            onClickAddCategory = { navHostController.navigateToAddCategoryScreen() },
            onClickBack = { navHostController.navigateUp() },
            onSelect = {
                navHostController.previousBackStackEntry?.savedStateHandle?.set("categoryId", it)
                navHostController.navigateUp()
            }
        )
        addCategoryScreen(
            onClickBack = { navHostController.navigateUp() }
        )
        viewAllExpenseScreen(onClickBack = { navHostController.navigateUp() })
    }
}
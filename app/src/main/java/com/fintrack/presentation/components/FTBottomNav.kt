package com.fintrack.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.fintrack.R
import com.fintrack.presentation.analytics.navigation.AnalyticsRoute
import com.fintrack.presentation.budget.navigation.BudgetRoute
import com.fintrack.presentation.expense.navigation.AddExpenseRoute
import com.fintrack.presentation.home.navigation.HomeRoute

/**
 * Created by fasil on 01/03/25.
 */
@Composable
fun FTBottomNav(navHostController: NavHostController) {
    val navItems = listOf(
        Triple(HomeRoute, "Home", Icons.Outlined.Home),
        Triple(AddExpenseRoute, "Add Expense", Icons.Outlined.Add),
        Triple(AnalyticsRoute, "Analytics", R.drawable.ic_analytics),
        Triple(BudgetRoute, "Budget", R.drawable.ic_budget),
    )
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    NavigationBar {
        navItems.forEach {  item ->
            val isSelected = currentDestination?.route == item.first::class.qualifiedName
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navHostController.navigate(item.first) {
                        popUpTo(HomeRoute) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    if (item.third is ImageVector) {
                        Icon(
                            imageVector = item.third as ImageVector,
                            contentDescription = item.second
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = item.third as Int),
                            contentDescription = item.second
                        )
                    }
                },
                label = {
                    Text(text = item.second)
                }
            )
        }
    }
}
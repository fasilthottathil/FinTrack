package com.fintrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fintrack.navigation.FinTrackNavHost
import com.fintrack.presentation.category.navigation.AddCategoryRoute
import com.fintrack.presentation.category.navigation.CategoriesRoute
import com.fintrack.presentation.components.FTBottomNav
import com.fintrack.ui.theme.FinTrackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()
            val navBackStackEntry by navHostController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            val shouldShowBottomNav = currentDestination?.route !in listOf(
                CategoriesRoute::class.qualifiedName,
                AddCategoryRoute::class.qualifiedName
            )
            FinTrackTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if (shouldShowBottomNav) {
                            FTBottomNav(navHostController)
                        }
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(if (shouldShowBottomNav) innerPadding else PaddingValues(0.dp))
                    ) {
                        FinTrackNavHost(navHostController = navHostController)
                    }
                }
            }
        }
    }
}

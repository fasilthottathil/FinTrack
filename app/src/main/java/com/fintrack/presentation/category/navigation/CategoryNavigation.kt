package com.fintrack.presentation.category.navigation

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.fintrack.presentation.category.add.AddCategoryScreen
import com.fintrack.presentation.category.add.AddCategoryViewModel
import com.fintrack.presentation.category.categories.CategoriesViewModel
import com.fintrack.presentation.category.categories.CategoryScreen
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

/**
 * Created by fasil on 01/03/25.
 */
@Serializable
data object CategoriesRoute

@Serializable
data object AddCategoryRoute

fun NavController.navigateToCategoriesScreen(
    navOptions: NavOptions? = null
) {
    this.navigate(CategoriesRoute, navOptions)
}

fun NavController.navigateToAddCategoryScreen(navOptions: NavOptions? = null) {
    this.navigate(AddCategoryRoute, navOptions)
}


fun NavGraphBuilder.categoriesScreen(
    onClickAddCategory: () -> Unit,
    onClickBack: () -> Unit,
    onSelect: (String) -> Unit
) {
    composable<CategoriesRoute> {
        val viewModel = koinViewModel<CategoriesViewModel>()
        CategoryScreen(
            onClickAddCategory = onClickAddCategory,
            onClickBack = onClickBack,
            state = viewModel.categories.collectAsStateWithLifecycle(),
            onSelect = onSelect
        )
    }
}

fun NavGraphBuilder.addCategoryScreen(onClickBack: () -> Unit) {
    composable<AddCategoryRoute> {
        val viewModel = koinViewModel<AddCategoryViewModel>()
        AddCategoryScreen(onClickBack = onClickBack, onClickAdd = viewModel::addCategory)
    }
}
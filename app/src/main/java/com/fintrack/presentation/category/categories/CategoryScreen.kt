package com.fintrack.presentation.category.categories

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.fintrack.data.local.db.entities.CategoryEntity
import com.fintrack.presentation.components.CategoryItem
import com.fintrack.ui.theme.Purple80

/**
 * Created by fasil on 01/03/25.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(
    onClickAddCategory: () -> Unit,
    onClickBack: () -> Unit,
    onSelect: (String) -> Unit,
    state: State<List<CategoryEntity>>
) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "Categories",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(1f)
                        )
                        IconButton(
                            onClick = onClickAddCategory,
                            colors = IconButtonDefaults.iconButtonColors(containerColor = Purple80)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null,
                                tint = Color.Black
                            )
                        }
                    }
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.clickable { onClickBack() }
                    )
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.value) {
                CategoryItem(categoryEntity = it, onClick = onSelect)
            }
        }
    }
}

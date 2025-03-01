package com.fintrack.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fintrack.data.local.db.entities.ExpenseWithCategory
import com.fintrack.presentation.components.BudgetCard
import com.fintrack.presentation.components.ExpenseItem

/**
 * Created by fasil on 01/03/25.
 */
@Composable
fun HomeScreen(
    totalSpent: State<Double>,
    totalBudget: State<Double>,
    recentExpenses: State<List<ExpenseWithCategory>>,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            BudgetCard(totalBudget.value, totalSpent.value)
        }
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "Recent Expenses",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                TextButton(onClick = {}) {
                    Text("View all")
                }
            }
        }
        items(recentExpenses.value) {
            ExpenseItem(it)
        }
    }
}
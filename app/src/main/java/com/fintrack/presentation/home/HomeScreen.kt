package com.fintrack.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.fintrack.R
import com.fintrack.data.local.db.entities.ExpenseWithCategory
import com.fintrack.presentation.components.BudgetCard
import com.fintrack.presentation.components.ExpenseItem

/**
 * Created by fasil on 01/03/25.
 */
@Composable
fun HomeScreen(
    onClickViewAll: () -> Unit,
    totalSpent: State<Double>,
    totalBudget: State<Double>,
    recentExpenses: State<List<ExpenseWithCategory>>,
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.no_data))
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
                TextButton(onClick = onClickViewAll) {
                    Text("View all")
                }
            }
        }
        if (recentExpenses.value.isEmpty()) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LottieAnimation(
                        composition = composition,
                        modifier = Modifier.size(200.dp),
                        iterations = Int.MAX_VALUE
                    )
                    Text("No expenses found", fontSize = 16.sp)
                }
            }
        }
        items(recentExpenses.value) {
            ExpenseItem(it)
        }
    }
}
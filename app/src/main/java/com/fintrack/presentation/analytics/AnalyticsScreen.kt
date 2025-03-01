package com.fintrack.presentation.analytics

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fintrack.data.local.db.entities.CategoryWithTotalBudget
import com.fintrack.data.local.db.entities.CategoryWithTotalSpent
import ir.ehsannarmani.compose_charts.ColumnChart
import ir.ehsannarmani.compose_charts.models.Bars

/**
 * Created by fasil on 01/03/25.
 */
@Composable
fun AnalyticsScreen(
    categoryWithBudget: State<List<CategoryWithTotalBudget>>,
    categoryWithSpent: State<List<CategoryWithTotalSpent>>
) {

    val list = mutableListOf<Bars>()
    categoryWithBudget.value.forEach {
        val mList = mutableListOf<Bars.Data>()
        mList.add(
            Bars.Data(
                label = "Budget",
                value = it.totalBudget,
                color = Brush.verticalGradient(listOf(Color.Green, Color.Green.copy(0.5f)))
            )
        )
        categoryWithSpent.value.find { spent -> spent.categoryId == it.categoryId }
            ?.let { spent ->
                mList.add(
                    Bars.Data(
                        label = "Spent",
                        value = spent.totalSpent,
                        color = Brush.verticalGradient(listOf(Color.Red, Color.Red.copy(0.5f)))
                    )
                )
            }
        list.add(Bars(label = it.name, values = mList))
    }

    if (list.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("No data found for showing the analytics")
        }
    } else {
        ColumnChart(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 22.dp),
            data = remember { list },
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            ),
        )
    }

}
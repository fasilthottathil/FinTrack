package com.fintrack.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fintrack.ui.theme.Blue
import com.fintrack.ui.theme.Blue10
import com.fintrack.util.roundTo2Scale

/**
 * Created by fasil on 01/03/25.
 */
@Composable
fun BudgetCard(totalBudget: Double, totalSpent: Double) {
    var remaining = totalBudget - totalSpent
    if (remaining < 0) {
        remaining = 0.0
    }
    val progress = totalSpent / totalBudget

    var brush = Brush.linearGradient(listOf(Blue10, Blue))
    if (progress > 0.9f) {
        brush = Brush.linearGradient(listOf(Color.Red, Color.Red.copy(alpha = 0.5f)))
    }

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = ShapeDefaults.Medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(brush = brush)
                .padding(16.dp),
        ) {
            Text("Total Budget", color = Color.White, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$${totalBudget.roundTo2Scale()}",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = { progress.toFloat() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp),
                color = Color.White,
                trackColor = Color.White.copy(alpha = 0.5f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Spent: $${totalSpent.roundTo2Scale()}", color = Color.White, fontSize = 14.sp)
                Text("Remaining: $${remaining.roundTo2Scale()}", color = Color.White, fontSize = 14.sp)
            }
        }
    }
}

@Preview
@Composable
private fun BudgetCardPreview() {
    BudgetCard(1000.0, 200.0)
}
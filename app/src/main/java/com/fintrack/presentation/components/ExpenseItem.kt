package com.fintrack.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fintrack.R
import com.fintrack.data.local.db.entities.ExpenseWithCategory
import com.fintrack.util.formatTimestamp
import com.fintrack.util.getColor
import com.fintrack.util.roundTo2Scale

/**
 * Created by fasil on 01/03/25.
 */
@Composable
fun ExpenseItem(expenseWithCategory: ExpenseWithCategory) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = ShapeDefaults.Small
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Box(
                modifier = Modifier
                    .background(
                        color = Color(expenseWithCategory.category.color?.getColor() ?: 0),
                        shape = CircleShape
                    )
                    .padding(8.dp), contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_money),
                    contentDescription = null,
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Row {
                    Text(
                        expenseWithCategory.expense.title,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        "${expenseWithCategory.expense.amount.roundTo2Scale()}",
                        fontWeight = FontWeight.Bold
                    )
                }
                Row {
                    Text(
                        expenseWithCategory.category.name,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        expenseWithCategory.expense.id.formatTimestamp(),
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

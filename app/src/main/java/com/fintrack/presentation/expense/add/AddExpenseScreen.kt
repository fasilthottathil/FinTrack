package com.fintrack.presentation.expense.add

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fintrack.data.local.db.entities.CategoryEntity
import com.fintrack.presentation.components.SuccessDialog

/**
 * Created by fasil on 01/03/25.
 */
@Composable
fun AddExpenseScreen(
    onClickCategory: () -> Unit,
    onClickAdd: (String, String) -> Unit,
    state: State<CategoryEntity?>
) {
    var amount by rememberSaveable { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var showSuccessDialog by remember { mutableStateOf(false) }
    LaunchedEffect(state.value) {
        if (state.value?.name.isNullOrEmpty().not()) {
            category = state.value?.name.orEmpty()
        }
    }

    if (showSuccessDialog) {
        SuccessDialog {
            showSuccessDialog = false
            amount = ""
            category = ""
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = amount,
            onValueChange = { newText ->
                if (newText.isEmpty() || newText.matches(Regex("^[0-9]*\\.?[0-9]*\$"))) {
                    val decimalCount = newText.count { it == '.' }
                    if (decimalCount <= 1) {
                        amount = newText
                    }
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Decimal),
            placeholder = {
                Text("$0.00", fontSize = 32.sp)
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            textStyle = TextStyle(fontSize = 32.sp),
            visualTransformation = VisualTransformation.None
        )
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .border(width = 1.dp, color = Color.Gray, shape = ShapeDefaults.Small)
                .clickable { onClickCategory() }
                .padding(start = 8.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                category.ifEmpty { "Select category" },
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            onClick = {
                onClickAdd(amount, category)
                showSuccessDialog = true
            },
            shape = ShapeDefaults.Small,
            enabled = category.isEmpty().not() && amount.isNotEmpty()
        ) {
            Text("Add Expense", fontSize = 22.sp)
        }
    }
}
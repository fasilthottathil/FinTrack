package com.fintrack.presentation.category.add

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fintrack.R
import com.fintrack.presentation.components.SuccessDialog
import com.fintrack.util.getColor

/**
 * Created by fasil on 01/03/25.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCategoryScreen(onClickBack: () -> Unit, onClickAdd: (String, String) -> Unit) {
    var name by remember { mutableStateOf("") }
    var showSuccessDialog by remember { mutableStateOf(false) }
    val colorList = listOf(
        "0xFF1E88E5",
        "0xFF4CAF50",
        "0xFF7E57C2",
        "0xFFEF6C00",
        "0xFFE91E63",
        "0xFFE53935",
        "0xFFF2A02E"
    )
    var selectedColor by remember { mutableStateOf(colorList[0]) }

    if (showSuccessDialog) {
        SuccessDialog {
            showSuccessDialog = false
            onClickBack()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        TopAppBar(
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "Create category",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
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
        Text("Category Name", fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(2.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { newText ->
                name = newText
            },
            placeholder = {
                Text("Enter category name")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            singleLine = true,
            shape = ShapeDefaults.Small
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text("Category color", fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(colorList) {
                val isSelected = it == selectedColor
                Box(
                    modifier = Modifier
                        .size(45.dp)
                        .background(color = Color(it.getColor()), shape = CircleShape)
                        .clickable { selectedColor = it },
                    contentAlignment = Alignment.Center
                ) {
                    if (isSelected) {
                        Icon(
                            painter = painterResource(R.drawable.ic_done),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            onClick = {
                onClickAdd(name, selectedColor)
                showSuccessDialog = true
            },
            shape = ShapeDefaults.Small,
            enabled = name.isNotEmpty() && name.isNotBlank()
        ) {
            Text("Save", fontSize = 18.sp)
        }
    }
}

@Preview
@Composable
private fun AddCategoryScreenPrev() {
    AddCategoryScreen(onClickBack = {}, onClickAdd = { _,_ -> })
}
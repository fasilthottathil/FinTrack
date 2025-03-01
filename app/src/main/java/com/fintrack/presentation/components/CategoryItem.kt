package com.fintrack.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fintrack.data.local.db.entities.CategoryEntity

/**
 * Created by fasil on 01/03/25.
 */
@Composable
fun CategoryItem(categoryEntity: CategoryEntity, onClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .clickable { onClick(categoryEntity.categoryId.toString()) }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(categoryEntity.name, fontSize = 16.sp, modifier = Modifier.weight(1f))
        Icon(imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight, contentDescription = null)
    }
}
package com.example.jetpackcompose.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R

@Composable
fun CategoryChip(
    category: String,
    isSelected: Boolean = false,
    onSelectedCategorySelected: (String) -> Unit,
    onExecuteSearch: () -> Unit,
) {
    Surface(
        modifier = Modifier.padding(4.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(
            size = 16.dp
        ),
        color = when {
            isSelected -> colorResource(R.color.teal_200)
            else -> colorResource(R.color.purple_500)
        }
    ) {
        Row(modifier = Modifier
            .toggleable(
                value = isSelected,
                onValueChange = {
                    onSelectedCategorySelected(category)
                    onExecuteSearch()
                }
            )) {
            Text(
                text = category,
                style = MaterialTheme.typography.body2,
                color = Color.White,
                modifier = Modifier.padding(
                    vertical = 8.dp,
                    horizontal = 12.dp
                )
            )
        }
    }
}
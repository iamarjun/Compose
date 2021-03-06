package com.example.jetpackcompose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.model.FoodCategory
import com.example.jetpackcompose.model.getAllFoodCategories
import kotlinx.coroutines.launch

@Composable
fun TopSearchBar(
    query: String,
    scrollPos: Int,
    selectedCategory: FoodCategory?,
    onQueryChange: (String) -> Unit,
    onCategorySelect: (String, Int) -> Unit,
    onExecuteSearch: (String) -> Unit,

    ) {

    Surface(
        elevation = 8.dp,
        modifier = Modifier.fillMaxWidth(),
        color = Color.White
    )
    {

        Column {

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                TextField(
                    value = query,
                    onValueChange = onQueryChange,
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(4.dp),
                    label = {
                        Text(text = "Search")
                    },
                    keyboardOptions = KeyboardOptions(
                        autoCorrect = true,
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search Icon"
                        )
                    },
                    textStyle = TextStyle(
                        color = MaterialTheme.colors.onSurface,
                        background = Color.Transparent,
                    ),

                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        backgroundColor = Color.White,
                    )


                )
            }

            val state = rememberLazyListState()
            val scope = rememberCoroutineScope()

            LazyRow(
                state = state
            ) {

                scope.launch {
                    state.animateScrollToItem(scrollPos)
                }

                itemsIndexed(items = getAllFoodCategories()) { index, item ->
                    CategoryChip(
                        category = item.value,
                        isSelected = selectedCategory == item,
                        onCategorySelected = {
                            onCategorySelect(it, index)
                        },
                        onExecuteSearch = onExecuteSearch
                    )
                }
            }

        }
    }

}
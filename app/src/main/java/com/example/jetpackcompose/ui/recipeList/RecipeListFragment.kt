package com.example.jetpackcompose.ui.recipeList

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import com.example.jetpackcompose.ui.BaseFragment
import com.example.jetpackcompose.ui.components.RecipeCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : BaseFragment() {

    private val viewModel by viewModels<RecipeListViewModel>()

    @Composable
    override fun MainContent() {
        val recipes = viewModel.recipes.value
        LazyColumn {
            itemsIndexed(items = recipes) { index, recipe ->
                RecipeCard(
                    recipe = recipe,
                    onClick = {

                    }
                )
            }
        }
    }
}
package com.example.jetpackcompose.ui.recipeList

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import com.example.jetpackcompose.ui.BaseFragment
import com.example.jetpackcompose.ui.components.RecipeCard
import com.example.jetpackcompose.ui.components.TopSearchBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : BaseFragment() {

    private val viewModel by viewModels<RecipeListViewModel>()

    @Composable
    override fun MainContent() {
        val recipes = viewModel.recipes.value
        val query = viewModel.query.value
        val selectedCategory = viewModel.selectedCategory.value

        Scaffold(topBar = {
            TopSearchBar(
                query = query,
                scrollPos = viewModel.scrollState,
                selectedCategory = selectedCategory,
                onQueryChanged = viewModel::onQueryChange,
                onCategorySelected = viewModel::onSelectedCategoryChanged,
                onExecuteSearch = viewModel::search
            )
        }) {
            LazyColumn {
                itemsIndexed(items = recipes) { _, recipe ->
                    RecipeCard(
                        recipe = recipe,
                        onClick = {

                        }
                    )
                }
            }
        }

    }
}
package com.example.jetpackcompose.ui.recipeList

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.example.jetpackcompose.ui.BaseFragment
import com.example.jetpackcompose.ui.components.RecipeCard
import com.example.jetpackcompose.ui.components.TopSearchBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : BaseFragment() {

    private val viewModel by viewModels<RecipeListViewModel>()

    @Composable
    override fun MainContent() {
        val query = viewModel.query.value
        val selectedCategory = viewModel.selectedCategory.value

        Scaffold(
            topBar = {
                TopSearchBar(
                    query = query,
                    scrollPos = viewModel.scrollState,
                    selectedCategory = selectedCategory,
                    onQueryChange = viewModel::onQueryChange,
                    onCategorySelect = viewModel::onCategorySelect,
                    onExecuteSearch = viewModel::search
                )
            }) {

            val lazyPagingItems = viewModel.recipes.value?.collectAsLazyPagingItems()

            LazyColumn {

                if (lazyPagingItems?.loadState?.refresh == LoadState.Loading) {
                    item {
                        Text(
                            text = "Waiting for items to load from the backend",
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.CenterHorizontally)
                        )
                    }
                }


                lazyPagingItems?.let {
                    itemsIndexed(it) { _, recipe ->
                        RecipeCard(
                            recipe = recipe!!,
                            onClick = {
                                findNavController().navigate(
                                    RecipeListFragmentDirections.actionRecipeListFragmentToRecipeFragment(
                                        recipe = recipe
                                    )
                                )
                            }
                        )
                    }
                }

                if (lazyPagingItems?.loadState?.append == LoadState.Loading) {
                    item {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.CenterHorizontally)
                        )
                    }
                }
            }
        }

    }
}
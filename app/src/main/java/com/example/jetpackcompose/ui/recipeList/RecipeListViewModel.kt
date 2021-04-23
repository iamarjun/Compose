package com.example.jetpackcompose.ui.recipeList

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.jetpackcompose.model.FoodCategory
import com.example.jetpackcompose.model.domain.Recipe
import com.example.jetpackcompose.model.getFoodCategory
import com.example.jetpackcompose.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val repository: RecipeRepository
) : ViewModel() {

    val recipes by lazy { mutableStateOf<Flow<PagingData<Recipe>>?>(null) }
    val query by lazy { mutableStateOf<String>("") }
    val selectedCategory by lazy { mutableStateOf<FoodCategory?>(null) }
    private var currentSearchResult: Flow<PagingData<Recipe>>? = null


    var scrollState: Int = 0
        private set

    fun search(queryString: String) {
        val lastResult = currentSearchResult
        if (queryString == query.value && lastResult != null) {
            recipes.value = lastResult
        }
        query.value = queryString
        val newResult: Flow<PagingData<Recipe>> = repository.getRecipes(queryString)
            .cachedIn(viewModelScope)
        currentSearchResult = newResult
        recipes.value = newResult
    }

    fun onQueryChange(query: String) {
        this.query.value = query
    }

    fun onCategorySelect(category: String, position: Int) {
        val foodCategory = getFoodCategory(category)
        selectedCategory.value = foodCategory
        onQueryChange(category)
        scrollState = position
    }

    companion object {
        private const val TAG = "RecipeListViewModel"
    }
}
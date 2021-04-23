package com.example.jetpackcompose.ui.recipeList

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.model.FoodCategory
import com.example.jetpackcompose.model.domain.Recipe
import com.example.jetpackcompose.model.getFoodCategory
import com.example.jetpackcompose.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val repository: RecipeRepository
) : ViewModel() {

    val recipes by lazy { mutableStateOf<List<Recipe>>(listOf()) }
    val query by lazy { mutableStateOf<String>("") }
    val selectedCategory by lazy { mutableStateOf<FoodCategory?>(null) }
    var scrollState: Int = 0
        private set

    init {
        search()
    }

    fun search() {
        viewModelScope.launch {
            try {
                val response = repository.getRecipes(query.value)
                recipes.value = response
            } catch (e: Exception) {
                Log.d(TAG, "search: $e")
            }
        }
    }

    fun onQueryChange(query: String) {
        this.query.value = query
    }

    fun onSelectedCategoryChanged(category: String, position: Int) {
        val foodCategory = getFoodCategory(category)
        selectedCategory.value = foodCategory
        onQueryChange(category)
        scrollState = position
    }

    companion object {
        private const val TAG = "RecipeListViewModel"
    }
}